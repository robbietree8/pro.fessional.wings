package pro.fessional.wings.slardar.serialize;

import com.alibaba.fastjson2.JSON;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

/**
 * 底层实现为FastJson，仅限于信任服务的简单类型，在非信任领域可能存在安全问题。
 * 对于有泛型的复杂类型，fastjson正确解析，此外有点注意js中number的精度问题。
 *
 * @author trydofor
 * @since 2022-03-09
 */
public class JsonConversion implements ConversionService {

    @Override
    public boolean canConvert(Class<?> sourceType, @NotNull Class<?> targetType) {
        return String.class.equals(sourceType) || String.class.equals(targetType);
    }

    @Override
    public boolean canConvert(TypeDescriptor sourceType, @NotNull TypeDescriptor targetType) {
        return (sourceType != null && String.class.equals(sourceType.getType())) ||
               (String.class.equals(targetType.getType()));
    }

    @SuppressWarnings("unchecked")
    @SneakyThrows
    @Override
    public <T> T convert(Object source, @NotNull Class<T> targetType) {
        if (source instanceof String) {
            return JSON.parseObject((String) source, targetType);
        }
        if (String.class.equals(targetType)) {
            return (T) JSON.toJSONString(source);
        }
        return null;
    }

    @SneakyThrows
    @Override
    public Object convert(Object source, TypeDescriptor sourceType, @NotNull TypeDescriptor targetType) {
        if (source instanceof String) {
            return JSON.parseObject((String) source, targetType.getType());
        }
        if (String.class.equals(targetType.getType())) {
            return JSON.toJSONString(source);
        }
        return null;
    }
}