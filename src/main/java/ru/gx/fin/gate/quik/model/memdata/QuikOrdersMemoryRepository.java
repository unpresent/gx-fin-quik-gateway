package ru.gx.fin.gate.quik.model.memdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import ru.gx.data.AbstractMemoryRepository;
import ru.gx.data.SingletonInstanceAlreadyExistsException;
import ru.gx.fin.gate.quik.model.internal.QuikOrder;
import ru.gx.fin.gate.quik.model.internal.QuikOrdersPackage;

public class QuikOrdersMemoryRepository extends AbstractMemoryRepository<QuikOrder, QuikOrdersPackage> {
    public QuikOrdersMemoryRepository(ObjectMapper objectMapper)
            throws SingletonInstanceAlreadyExistsException {
        super(objectMapper);
    }

    @Override
    @NotNull
    public Object extractKey(QuikOrder quikOrder) {
        return quikOrder.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikOrdersMemoryRepository> {
    }
}
