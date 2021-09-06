package ru.gxfin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gxfin.common.data.AbstractMemoryRepository;
import ru.gxfin.common.data.SingletonInstanceAlreadyExistsException;
import ru.gxfin.gate.quik.model.internal.QuikOrder;
import ru.gxfin.gate.quik.model.internal.QuikOrdersPackage;

public class QuikOrdersMemoryRepository extends AbstractMemoryRepository<QuikOrder, QuikOrdersPackage> {
    public QuikOrdersMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    public Object extractKey(QuikOrder quikOrder) {
        return quikOrder.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikOrdersMemoryRepository> {
    }
}
