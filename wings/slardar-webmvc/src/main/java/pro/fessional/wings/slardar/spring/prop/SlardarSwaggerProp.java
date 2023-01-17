package pro.fessional.wings.slardar.spring.prop;

import io.swagger.v3.oas.models.parameters.CookieParameter;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.PathParameter;
import io.swagger.v3.oas.models.parameters.QueryParameter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author trydofor
 * @see #Key
 * @since 2021-02-14
 */
@Data
@ConfigurationProperties(SlardarSwaggerProp.Key)
public class SlardarSwaggerProp {

    public static final String Key = "wings.slardar.swagger";

    /**
     * @see #Key$title
     */
    private String title = "";
    public static final String Key$title = Key + ".title";

    /**
     * @see #Key$description
     */
    private String description = "";
    public static final String Key$description = Key + ".description";

    /**
     * 需要开启 build info
     *
     * @see #Key$version
     */
    private String version = "";
    public static final String Key$version = Key + ".version";

    /**
     * key采用java命名,作为$ref使用，in支持cookie|header|query|path
     *
     * @see #Key$param
     */
    private Map<String, EnabledParameter> param = new HashMap<>();
    public static final String Key$param = Key + ".param";

    /**
     * Accept/MediaType复制，以出现多个请求方式
     *
     * @see #Key$accept
     */
    private Map<String, String> accept = new HashMap<>();
    public static final String Key$accept = Key + ".accept";

    /**
     * 是否把PageQuery扁平化，作为querystring参数
     *
     * @see #Key$flatPagequery
     */
    private boolean flatPagequery = true;
    public static final String Key$flatPagequery = Key + ".flat-pagequery";

    public List<Parameter> toRefPara() {
        List<Parameter> result = new ArrayList<>();
        for (Map.Entry<String, EnabledParameter> en : param.entrySet()) {
            final EnabledParameter para = en.getValue();
            if (!para.isEnable()) continue;

            final Parameter sub = subParam(para);
            sub.set$ref("#/components/parameters/" + en.getKey());
            result.add(sub);
        }
        return result;
    }

    public Map<String, Parameter> toComPara() {
        Map<String, Parameter> map = new HashMap<>();
        for (Map.Entry<String, EnabledParameter> en : param.entrySet()) {
            final EnabledParameter para = en.getValue();
            if (!para.isEnable()) continue;

            final Parameter sub = subParam(para);
            BeanUtils.copyProperties(para, sub);
            map.put(en.getKey(), para);
        }

        return map;
    }

    //  cookie|header|query|path
    @NotNull
    private Parameter subParam(Parameter para) {
        final String in = para.getIn();
        final Parameter sub;
        if ("cookie".equalsIgnoreCase(in)) {
            sub = new CookieParameter();
        }
        else if ("header".equalsIgnoreCase(in)) {
            sub = new HeaderParameter();
        }
        else if ("query".equalsIgnoreCase(in)) {
            sub = new QueryParameter();
        }
        else if ("path".equalsIgnoreCase(in)) {
            sub = new PathParameter();
        }
        else {
            throw new IllegalArgumentException("unsupported type=" + para);
        }
        return sub;
    }

    @Setter @Getter
    public static class EnabledParameter extends Parameter {
        private boolean enable = true;
    }
}
