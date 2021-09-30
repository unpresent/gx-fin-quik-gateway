package ru.gx.fin.gate.quik.model.memdata;

import org.jetbrains.annotations.NotNull;
import ru.gx.data.AbstractMemoryRepository;
import ru.gx.fin.gate.quik.model.internal.QuikSecuritiesPackage;
import ru.gx.fin.gate.quik.model.internal.QuikSecurity;

public class QuikSecuritiesMemoryRepository extends AbstractMemoryRepository<QuikSecurity, QuikSecuritiesPackage> {
    @Override
    @NotNull
    public Object extractKey(QuikSecurity quikSecurity) {
        return quikSecurity.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikSecuritiesMemoryRepository> {
    }
}
