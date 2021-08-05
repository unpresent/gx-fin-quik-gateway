package ru.gxfin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gxfin.common.data.AbstractDataPackage;
import ru.gxfin.gate.quik.model.original.OriginalQuikStandardDataObject;
import ru.gxfin.gate.quik.model.original.OriginalQuikStandardDataPackage;

import java.util.Collection;

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
    public QuikStandardDataPackage(OriginalQuikStandardDataPackage quikDataPackage) {
        super();
        this.allCount = quikDataPackage.getQuikAllCount();
        final var n = quikDataPackage.size();
        for (int i = 0; i < n; i++) {
            this.getListObjects().add(createInstanceFromQuikSource((OriginalQuikStandardDataObject)quikDataPackage.get(i)));
        }
    }
}
