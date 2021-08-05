package ru.gxfin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gxfin.common.data.AbstractMemoryRepository;
import ru.gxfin.common.data.ObjectCreateException;
import ru.gxfin.common.data.SingletonInstanceAlreadyExistsException;
import ru.gxfin.gate.quik.model.internal.QuikOrder;
import ru.gxfin.gate.quik.model.internal.QuikOrdersPackage;

public class QuikOrdersMemoryRepository extends AbstractMemoryRepository<QuikOrder, QuikOrdersPackage> {
    public QuikOrdersMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    protected QuikOrder internalCreateEmptyInstance() {
        return new QuikOrder();
    }

    public static class IdResolver extends AbstractIdResolver {
        @SuppressWarnings("rawtypes")
        @Override
        protected Class<? extends AbstractMemoryRepository> getRepositoryClass() {
            return QuikOrdersMemoryRepository.class;
        }
    }

    public static class ObjectsFactory extends AbstractObjectsFactory {
        public static QuikOrder getOrCreateObject(String id) throws ObjectCreateException {
            return AbstractObjectsFactory.getOrCreateObject(QuikOrder.class, id);
        }
    }
}
