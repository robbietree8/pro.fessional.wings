package pro.fessional.wings.faceless.util;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import pro.fessional.mirana.io.InputStreams;
import pro.fessional.wings.faceless.enums.tmpl.ConstantEnumTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 名字转换中，`-`变成`_`，ascii中非java字符，用狮子替换
 *
 * @author trydofor
 * @since 2019-09-24
 */
public class ConstantEnumGenerator {

    private static final Logger logger = LoggerFactory.getLogger(ConstantEnumGenerator.class);

    @Data
    public static class ConstantEnum {
        private int id;
        private String type;
        private String code;
        private String desc;
        private String info;
    }

    public static <T> List<ConstantEnum> copyField(Class<T> clazz, Collection<T> pojos) {
        try {
            List<ConstantEnum> list = new ArrayList<>(pojos.size());
            String[] methodNames = {"getId", "getType", "getCode", "getDesc", "getInfo"};
            Method[] methodPojos = new Method[methodNames.length];
            for (int i = 0; i < methodNames.length; i++) {
                methodPojos[i] = clazz.getMethod(methodNames[i]);
            }
            for (T pojo : pojos) {
                ConstantEnum ce = new ConstantEnum();
                ce.id = (Integer) methodPojos[0].invoke(pojo);
                ce.type = (String) methodPojos[1].invoke(pojo);
                ce.code = (String) methodPojos[2].invoke(pojo);
                ce.desc = (String) methodPojos[3].invoke(pojo);
                ce.info = (String) methodPojos[4].invoke(pojo);
                list.add(ce);
            }
            return list;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private File src;
        private String pkg;
        Set<String> exs = new HashSet<>();

        public Builder setJavaSource(File src) {
            this.src = src;
            return this;
        }

        public Builder setJavaSource(String src) {
            this.src = new File(src);
            return this;
        }

        public Builder setJavaPackage(String pkg) {
            this.pkg = pkg;
            return this;
        }

        public Builder addExcludeType(String typ) {
            this.exs.add(typ);
            return this;
        }

        public Builder addExcludeType(String... typ) {
            this.exs.addAll(Arrays.asList(typ));
            return this;
        }

        public <T> void generate(Class<T> clazz, Collection<T> pos) throws IOException {
            List<ConstantEnum> enums = ConstantEnumGenerator.copyField(clazz, pos);
            generate(enums);
        }

        public void generate(Collection<ConstantEnum> pos) throws IOException {
            ConstantEnumGenerator.generate(src, pkg, pos, exs);
        }
    }

    /**
     * first, copy ConstantEnumTemplate.java to /resource/ to avoid compile
     *
     * @param src      ./src/main/java/
     * @param pkg      pro.fessional.wings.faceless.enums.constant
     * @param pojos    对象数据
     * @param excludes 排除的type组
     * @throws IOException if IO exception
     * @see ConstantEnumTemplate
     */
    public static void generate(File src, String pkg, Collection<ConstantEnum> pojos, Set<String> excludes) throws IOException {
        // 初始
        Map<String, List<ConstantEnum>> enums = pojos
                .stream()
                .filter(it -> excludes.isEmpty() || !excludes.contains(it.type))
                .collect(Collectors.groupingBy(ConstantEnum::getType));

        int count = 1;
        for (Map.Entry<String, List<ConstantEnum>> e : enums.entrySet()) {
            logger.info("load {} enum type = {}, count={}", count++, e.getKey(), e.getValue().size());
        }

        Set<File> nowFiles = new HashSet<>();
        File dst = new File(src, pkg.replace('.', '/'));
        dst.mkdirs();

        Map<String, String> tmplParsed = new HashMap<>();
        for (Map.Entry<String, List<ConstantEnum>> enun : enums.entrySet()) {
            String type = enun.getKey();
            List<ConstantEnum> vals = enun.getValue();

            ConstantEnum root = vals
                    .stream()
                    .filter(ConstantEnumGenerator::isSuper)
                    .findFirst()
                    .get();

            String tmpl = tmplParsed.computeIfAbsent(root.info, k -> parse(root, pkg));
            String text = merge(tmpl, root, type, vals);

            File java = new File(dst, javaClass(type) + ".java");
            if (java.isFile()) {
                nowFiles.add(java);
                String jtxt = InputStreams.readText(new FileInputStream(java), StandardCharsets.UTF_8);
                String jb = jtxt.replaceAll("@since [0-9-]+", "").trim();
                String tb = text.replaceAll("@since [0-9-]+", "").trim();
                if (jb.equals(tb)) {
                    logger.info("skip same {}", java.getName());
                    continue;
                }
            }
            try (FileOutputStream fos = new FileOutputStream(java)) {
                fos.write(text.getBytes(StandardCharsets.UTF_8));
                nowFiles.add(java);
                logger.info("make {} to {}", type, java.getName());
            }
        }

        File[] files = dst.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!nowFiles.contains(file)) {
                    logger.info("exceed file {}", file.getName());
                }
            }
        }
    }

    private static String parse(ConstantEnum root, String pkg) {
        StringBuilder sb = new StringBuilder();
        Pattern useIdAsKey = Pattern.compile("\\s*useIdAsKey\\s*=\\s*(false|true)");
        Pattern className = Pattern.compile("public\\s+enum\\s+(\\S+)\\s+");

        List<String> txt;
        try {
            DefaultResourceLoader loader = new DefaultResourceLoader();
            txt = InputStreams.readLine(loader.getResource(root.info).getInputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        String pascalName = "not init";
        boolean notUseIdAsKey = true;
        boolean notClassName = true;
        for (String s : txt) {
            if (s.startsWith("package ")) {
                sb.append("package ").append(pkg).append(";");
            } else if (s.contains("@since ")) {
                sb.append(s, 0, s.indexOf("@since "));
                sb.append("@since ").append(LocalDate.now().toString());
            } else if (s.contains("SUPER")) {
                sb.append(VAR_SUPER);
            } else if (s.contains(pascalName)) {
                sb.append(s.replace(pascalName, VAR_CLASS));
            } else {
                if (notUseIdAsKey) {
                    Matcher key = useIdAsKey.matcher(s);
                    if (key.find()) {
                        sb.append(s.replace(key.group(1), VAR_IDKEY));
                        notUseIdAsKey = false;
                        continue;
                    }
                }
                if (notClassName) {
                    Matcher key = className.matcher(s);
                    if (key.find()) {
                        pascalName = key.group(1);
                        sb.append(s.replace(pascalName, VAR_CLASS));
                        notClassName = false;
                        continue;
                    }
                }

                sb.append(s);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static final String VAR_TYPE = "{sys_constant_enum.type}";
    public static final String VAR_SUPER = "{java.enum.field.SUPER}";
    public static final String VAR_CLASS = "{java.enum.class.Pascal}";
    public static final String VAR_IDKEY = "{java.enum.field.useIdAsKey}";

    private static String merge(String tmpl, ConstantEnum root, String type, List<ConstantEnum> list) {
        String pascal = javaClass(type);
        list.sort(Comparator.comparingLong(ConstantEnum::getId));
        String text = fields("    ", list);

        tmpl = tmpl.replace(VAR_SUPER, text);
        tmpl = tmpl.replace(VAR_CLASS, pascal);
        tmpl = tmpl.replace(VAR_TYPE, type);
        tmpl = tmpl.replace(VAR_IDKEY, String.valueOf(root.code.equalsIgnoreCase("id")));

        return tmpl;
    }

    private static final String A9 = "\uD80C\uDCEC";

    private static boolean isSuper(ConstantEnum it) {
        return it.getId() % 100 == 0;
    }

    private static String fields(String indent, List<ConstantEnum> its) {
        StringBuilder enums = new StringBuilder();
        StringBuilder codes = new StringBuilder();

        for (ConstantEnum it : its) {
            enums.append(indent);
            codes.append(indent);
            int idx = enums.length();
            boolean isSuper = isSuper(it);
            if (isSuper) {
                enums.append("SUPER");
            } else {
                String code = it.code;
                int len = code.length();
                boolean canDeer = true;
                for (int i = 0; i < len; i++) {
                    char c = code.charAt(i);
                    if (c == '-') {
                        enums.append('_');
                    } else if (c >= 'a' && c <= 'z') {
                        enums.append(Character.toUpperCase(c));
                    } else if (Character.isJavaIdentifierPart(c)) {
                        enums.append(c);
                    } else if (c > 127) {
                        enums.append(c);
                    } else {
                        if (enums.length() > 0 && canDeer) {
                            canDeer = false;
                            enums.append(A9);
                            continue;
                        }
                    }
                    canDeer = true;
                }
            }
            String code = isSuper ? it.type : it.code;
            // public static final String $CREATE_USER = "CREATE_USER"
            codes.append("public static final String $");
            codes.append(enums, idx, enums.length());
            codes.append(" = \"").append(code).append("\";\n");

            enums.append("(")
                 .append(it.id)
                 .append(", \"")
                 .append(code)
                 .append("\", \"")
                 .append(it.desc)
                 .append("\", \"")
                 .append(it.info)
                 .append("\"),\n");
        }

        enums.append(indent)
             .append(";\n")
             .append(codes.toString())
        ;
        return enums.toString();
    }

    @NotNull
    private static String javaClass(String type) {
        StringBuilder pascal = new StringBuilder();
        boolean up = true;
        for (int i = 0; i < type.length(); i++) {
            char c = type.charAt(i);
            if (up) c = Character.toUpperCase(c);
            if (c == '_') {
                up = true;
            } else {
                up = false;
                pascal.append(c);
            }
        }
        return pascal.toString();
    }
}
