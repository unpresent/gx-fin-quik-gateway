package ru.gx.fin.gate.quik.model.memdata;

import org.jetbrains.annotations.NotNull;
import ru.gx.data.AbstractMemoryRepository;
import ru.gx.fin.gate.quik.model.internal.QuikAllTrade;
import ru.gx.fin.gate.quik.model.internal.QuikAllTradesPackage;

public class QuikAllTradesMemoryRepository extends AbstractMemoryRepository<QuikAllTrade, QuikAllTradesPackage> {
    @Override
    @NotNull
    public Object extractKey(QuikAllTrade quikAllTrade) {
        return quikAllTrade.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikAllTradesMemoryRepository> {
    }
}
