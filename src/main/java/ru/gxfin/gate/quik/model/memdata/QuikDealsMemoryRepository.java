package ru.gxfin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gxfin.common.data.AbstractMemoryRepository;
import ru.gxfin.common.data.SingletonInstanceAlreadyExistsException;
import ru.gxfin.gate.quik.model.internal.QuikDeal;
import ru.gxfin.gate.quik.model.internal.QuikDealsPackage;

public class QuikDealsMemoryRepository extends AbstractMemoryRepository<QuikDeal, QuikDealsPackage> {
    public QuikDealsMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    public Object extractKey(QuikDeal quikDeal) {
        return quikDeal.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikDealsMemoryRepository> {
    }
}
