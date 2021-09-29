package ru.gx.fin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import ru.gx.fin.gate.quik.model.internal.QuikDeal;
import ru.gx.fin.gate.quik.model.internal.QuikDealsPackage;
import ru.gx.data.AbstractMemoryRepository;
import ru.gx.data.SingletonInstanceAlreadyExistsException;

public class QuikDealsMemoryRepository extends AbstractMemoryRepository<QuikDeal, QuikDealsPackage> {
    public QuikDealsMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    @NotNull
    public Object extractKey(QuikDeal quikDeal) {
        return quikDeal.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikDealsMemoryRepository> {
    }
}
