package ru.gxfin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gxfin.common.data.AbstractMemoryRepository;
import ru.gxfin.common.data.ObjectCreateException;
import ru.gxfin.common.data.SingletonInstanceAlreadyExistsException;
import ru.gxfin.gate.quik.model.internal.QuikDeal;
import ru.gxfin.gate.quik.model.internal.QuikDealsPackage;

public class QuikDealsMemoryRepository extends AbstractMemoryRepository<QuikDeal, QuikDealsPackage> {
    public QuikDealsMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    protected QuikDeal internalCreateEmptyInstance() {
        return new QuikDeal();
    }

    public static class IdResolver extends AbstractIdResolver {
        @SuppressWarnings("rawtypes")
        @Override
        protected Class<? extends AbstractMemoryRepository> getRepositoryClass() {
            return QuikDealsMemoryRepository.class;
        }
    }

    public static class ObjectsFactory extends AbstractObjectsFactory {
        public static QuikDeal getOrCreateObject(String id) throws ObjectCreateException {
            return AbstractObjectsFactory.getOrCreateObject(QuikDeal.class, id);
        }
    }
}
