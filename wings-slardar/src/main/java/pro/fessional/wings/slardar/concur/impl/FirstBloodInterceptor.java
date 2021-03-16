package pro.fessional.wings.slardar.concur.impl;

import com.github.benmanes.caffeine.cache.Cache;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import pro.fessional.wings.slardar.concur.FirstBlood;
import pro.fessional.wings.slardar.concur.ProgressContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author trydofor
 * @since 2021-03-10
 */
public class FirstBloodInterceptor implements HandlerInterceptor {

    private final List<FirstBloodHandler> handlers;

    public FirstBloodInterceptor(List<FirstBloodHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request,
                             @NotNull HttpServletResponse response,
                             @NotNull Object handler) {

        if (!(handler instanceof HandlerMethod) || handlers == null || handlers.isEmpty()) {
            return true;
        }

        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        final Method method = handlerMethod.getMethod();
        final FirstBlood anno = method.getAnnotation(FirstBlood.class);

        if (anno == null) return true;

        for (FirstBloodHandler hd : handlers) {
            if (hd.accept(request, anno)) {
                final Cache<Object, Object> cache = ProgressContext.get(anno.blood());
                return hd.handle(request, response, handlerMethod, cache, anno);
            }
        }

        return true;
    }
}
