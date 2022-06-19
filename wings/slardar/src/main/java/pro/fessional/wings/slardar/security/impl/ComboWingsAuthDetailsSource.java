package pro.fessional.wings.slardar.security.impl;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.Ordered;
import pro.fessional.mirana.func.Dcl;
import pro.fessional.wings.slardar.security.WingsAuthDetails;
import pro.fessional.wings.slardar.security.WingsAuthDetailsSource;
import pro.fessional.wings.slardar.security.WingsAuthHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author trydofor
 * @since 2021-02-17
 */
public class ComboWingsAuthDetailsSource implements WingsAuthDetailsSource<WingsAuthDetails> {

    private final List<Combo<?>> combos = new ArrayList<>();
    private final Dcl dclCombos = Dcl.of(() -> combos.sort(Comparator.comparingInt(Combo::getOrder)));

    @Override
    public WingsAuthDetails buildDetails(@NotNull Enum<?> authType, @NotNull HttpServletRequest request) {
        dclCombos.runIfDirty();
        WingsAuthDetails detail = null;
        for (Combo<?> cb : combos) {
            detail = cb.buildDetails(authType, request);
            if (detail != null) break;
        }
        if (detail == null) {
            detail = new DefaultWingsAuthDetails();
        }

        buildMetaData(authType, request, detail);

        return detail;
    }

    public final void add(Combo<?> source) {
        if (source == null) return;
        combos.add(source);
        dclCombos.setDirty();
    }

    public final void addAll(Collection<? extends Combo<?>> source) {
        if (source == null) return;
        combos.addAll(source);
        dclCombos.setDirty();
    }

    protected void buildMetaData(@NotNull Enum<?> authType, @NotNull HttpServletRequest request, @NotNull WingsAuthDetails details) {
        final Map<String, String> map = details.getMetaData();
        final String zone = WingsAuthHelper.getAuthZoneAttribute(request);
        if(zone != null) {
            map.putIfAbsent(WingsAuthHelper.AuthZone, zone);
        }
    }

    public interface Combo<T extends WingsAuthDetails> extends Ordered {
        /**
         * 不接受或无法构造返回null
         *
         * @param authType authType
         * @param request  request
         * @return details or null
         */
        T buildDetails(@NotNull Enum<?> authType, @NotNull HttpServletRequest request);
    }
}