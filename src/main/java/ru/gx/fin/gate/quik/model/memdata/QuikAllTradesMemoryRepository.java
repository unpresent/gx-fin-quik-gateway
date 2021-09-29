package ru.gx.fin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import ru.gx.fin.gate.quik.model.internal.QuikAllTrade;
import ru.gx.data.AbstractMemoryRepository;
import ru.gx.data.SingletonInstanceAlreadyExistsException;
import ru.gx.fin.gate.quik.model.internal.QuikAllTradesPackage;

public class QuikAllTradesMemoryRepository extends AbstractMemoryRepository<QuikAllTrade, QuikAllTradesPackage> {
    public QuikAllTradesMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    @NotNull
    public Object extractKey(QuikAllTrade quikAllTrade) {
        return quikAllTrade.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikAllTradesMemoryRepository> {
    }
}
