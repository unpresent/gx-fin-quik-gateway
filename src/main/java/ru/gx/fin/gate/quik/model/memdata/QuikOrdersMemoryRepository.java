package ru.gx.fin.gate.quik.model.memdata;

import org.jetbrains.annotations.NotNull;
import ru.gx.data.AbstractMemoryRepository;
import ru.gx.fin.gate.quik.model.internal.QuikOrder;
import ru.gx.fin.gate.quik.model.internal.QuikOrdersPackage;

public class QuikOrdersMemoryRepository extends AbstractMemoryRepository<QuikOrder, QuikOrdersPackage> {
    @Override
    @NotNull
    public Object extractKey(QuikOrder quikOrder) {
        return quikOrder.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikOrdersMemoryRepository> {
    }
}
