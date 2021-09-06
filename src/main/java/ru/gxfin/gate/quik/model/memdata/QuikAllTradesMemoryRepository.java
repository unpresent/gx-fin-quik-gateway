package ru.gxfin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gxfin.common.data.AbstractMemoryRepository;
import ru.gxfin.common.data.SingletonInstanceAlreadyExistsException;
import ru.gxfin.gate.quik.model.internal.QuikAllTrade;
import ru.gxfin.gate.quik.model.internal.QuikAllTradesPackage;

public class QuikAllTradesMemoryRepository extends AbstractMemoryRepository<QuikAllTrade, QuikAllTradesPackage> {
    public QuikAllTradesMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    public Object extractKey(QuikAllTrade quikAllTrade) {
        return quikAllTrade.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikAllTradesMemoryRepository> {
    }
}
