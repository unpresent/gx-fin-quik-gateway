package ru.gxfin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gxfin.common.data.AbstractMemoryRepository;
import ru.gxfin.common.data.ObjectCreateException;
import ru.gxfin.common.data.SingletonInstanceAlreadyExistsException;
import ru.gxfin.gate.quik.model.internal.QuikSecuritiesPackage;
import ru.gxfin.gate.quik.model.internal.QuikSecurity;

public class QuikSecuritiesMemoryRepository extends AbstractMemoryRepository<QuikSecurity, QuikSecuritiesPackage> {
    public QuikSecuritiesMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    protected QuikSecurity internalCreateEmptyInstance() {
        return new QuikSecurity();
    }

    public static class IdResolver extends AbstractIdResolver {
        @SuppressWarnings("rawtypes")
        @Override
        protected Class<? extends AbstractMemoryRepository> getRepositoryClass() {
            return QuikSecuritiesMemoryRepository.class;
        }
    }

    public static class ObjectsFactory extends AbstractObjectsFactory {
        public static QuikSecurity getOrCreateObject(String id) throws ObjectCreateException {
            return AbstractObjectsFactory.getOrCreateObject(QuikSecurity.class, id);
        }
    }
}
