package ru.gx.fin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;
import ru.gx.data.AbstractDataPackage;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataPackage;

public abstract class QuikStandardDataPackage<T extends QuikStandardDataObject> extends AbstractDataPackage<T> {
    /**
     * Общее количество записей в Quik-е
     */
    @JsonProperty
    public long allCount;

    @SuppressWarnings("unused")
    public T getObject(int index) {
        return super.get(index);
    }

    abstract public T createInstanceFromQuikSource(OriginalQuikStandardDataObject quikDataObject);

    public QuikStandardDataPackage() {
        super();
    }

    @SuppressWarnings("rawtypes")
    public QuikStandardDataPackage(OriginalQuikStandardDataPackage originalQuikDataPackage) {
        super();
        this.allCount = originalQuikDataPackage.getQuikAllCount();
        final var n = originalQuikDataPackage.size();
        for (int i = 0; i < n; i++) {
            this.getListObjects().add(createInstanceFromQuikSource((OriginalQuikStandardDataObject)originalQuikDataPackage.get(i)));
        }
    }
}
