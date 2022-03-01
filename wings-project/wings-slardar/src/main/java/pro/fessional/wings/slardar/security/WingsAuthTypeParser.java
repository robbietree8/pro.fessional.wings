package pro.fessional.wings.slardar.security;

import org.jetbrains.annotations.NotNull;
import pro.fessional.mirana.data.Null;

/**
 * @author trydofor
 * @since 2021-02-08
 */
public interface WingsAuthTypeParser {
    /**
     * 获取通过字符串别名，解析成enum类
     *
     * @param authType authType
     * @param elz      default
     * @return 枚举类
     */
    @NotNull
    Enum<?> parse(String authType, @NotNull Enum<?> elz);

    /**
     * 获取通过字符串别名，解析成enum类，null返回Null.Enm
     *
     * @param authType authType
     * @return 枚举类
     */
    @NotNull
    default Enum<?> parse(String authType){
        return parse(authType, Null.Enm);
    }

    /**
     * 把enum类，变成字符串别名，无法转换时PC异常
     *
     * @param authType authType
     * @return 字符串型
     * @throws IllegalArgumentException 无法转换时
     */
    @NotNull String parse(Enum<?> authType);
}
