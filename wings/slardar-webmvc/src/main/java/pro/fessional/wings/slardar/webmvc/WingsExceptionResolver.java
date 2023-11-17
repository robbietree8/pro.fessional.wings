package pro.fessional.wings.slardar.webmvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import pro.fessional.wings.slardar.servlet.response.view.PlainTextView;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author trydofor
 * @since 2021-03-25
 */
@Slf4j
public abstract class WingsExceptionResolver<T extends Exception> extends AbstractHandlerExceptionResolver {

    protected final Class<?> acceptClass;

    protected WingsExceptionResolver() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) {
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        acceptClass = (Class<?>) ((ParameterizedType) superClass).getActualTypeArguments()[0];
        log.info("WingsExceptionResolver={}, Exception={}", this.getClass().getName(), acceptClass);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected ModelAndView doResolveException(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response, Object handler,
            @NotNull Exception ex) {

        if (acceptClass.isInstance(ex)) {
            final SimpleResponse body = resolve((T) ex);
            if (body == null) return null;
            ModelAndView mav = new ModelAndView();
            PlainTextView pv = new PlainTextView(body.getContentType(), body.getResponseBody());
            mav.setStatus(HttpStatus.valueOf(body.getHttpStatus()));
            mav.setView(pv);
            return mav;
        }

        return null;
    }

    /**
     * Resolve Exception
     *
     * @param ex current exception
     * @return null if not support
     */
    protected abstract SimpleResponse resolve(T ex);
}