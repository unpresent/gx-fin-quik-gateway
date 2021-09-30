package ru.gx.fin.gate.quik.model.memdata;

import org.jetbrains.annotations.NotNull;
import ru.gx.data.AbstractMemoryRepository;
import ru.gx.fin.gate.quik.model.internal.QuikDeal;
import ru.gx.fin.gate.quik.model.internal.QuikDealsPackage;

public class QuikDealsMemoryRepository extends AbstractMemoryRepository<QuikDeal, QuikDealsPackage> {
    @Override
    @NotNull
    public Object extractKey(QuikDeal quikDeal) {
        return quikDeal.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikDealsMemoryRepository> {
    }
}
