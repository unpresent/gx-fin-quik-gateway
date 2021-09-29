package ru.gx.fin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import ru.gx.fin.gate.quik.model.internal.QuikSecuritiesPackage;
import ru.gx.fin.gate.quik.model.internal.QuikSecurity;
import ru.gx.data.AbstractMemoryRepository;
import ru.gx.data.SingletonInstanceAlreadyExistsException;

public class QuikSecuritiesMemoryRepository extends AbstractMemoryRepository<QuikSecurity, QuikSecuritiesPackage> {
    public QuikSecuritiesMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    @NotNull
    public Object extractKey(QuikSecurity quikSecurity) {
        return quikSecurity.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikSecuritiesMemoryRepository> {
    }
}
