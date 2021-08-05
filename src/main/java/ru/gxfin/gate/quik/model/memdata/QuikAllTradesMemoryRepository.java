package ru.gxfin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gxfin.common.data.AbstractMemoryRepository;
import ru.gxfin.common.data.ObjectCreateException;
import ru.gxfin.common.data.SingletonInstanceAlreadyExistsException;
import ru.gxfin.gate.quik.model.internal.QuikAllTrade;
import ru.gxfin.gate.quik.model.internal.QuikAllTradesPackage;

public class QuikAllTradesMemoryRepository extends AbstractMemoryRepository<QuikAllTrade, QuikAllTradesPackage> {
    public QuikAllTradesMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    protected QuikAllTrade internalCreateEmptyInstance() {
        return new QuikAllTrade();
    }

    public static class IdResolver extends AbstractIdResolver {
        @SuppressWarnings("rawtypes")
        @Override
        protected Class<? extends AbstractMemoryRepository> getRepositoryClass() {
            return QuikAllTradesMemoryRepository.class;
        }
    }

    public static class ObjectsFactory extends AbstractObjectsFactory {
        public static QuikAllTrade getOrCreateObject(String id) throws ObjectCreateException {
            return AbstractObjectsFactory.getOrCreateObject(QuikAllTrade.class, id);
        }
    }
}
