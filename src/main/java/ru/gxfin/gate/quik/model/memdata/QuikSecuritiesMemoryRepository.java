package ru.gxfin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gxfin.common.data.AbstractMemoryRepository;
import ru.gxfin.common.data.SingletonInstanceAlreadyExistsException;
import ru.gxfin.gate.quik.model.internal.QuikSecuritiesPackage;
import ru.gxfin.gate.quik.model.internal.QuikSecurity;

public class QuikSecuritiesMemoryRepository extends AbstractMemoryRepository<QuikSecurity, QuikSecuritiesPackage> {
    public QuikSecuritiesMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    public Object extractKey(QuikSecurity quikSecurity) {
        return quikSecurity.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikSecuritiesMemoryRepository> {
    }
}
