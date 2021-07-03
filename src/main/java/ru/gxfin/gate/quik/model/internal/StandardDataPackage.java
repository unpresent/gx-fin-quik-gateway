package ru.gxfin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gxfin.common.data.AbstractDataPackage;
import ru.gxfin.gate.quik.model.income.QuikStandardDataObject;
import ru.gxfin.gate.quik.model.income.QuikStandardDataPackage;

import java.util.Collection;

public abstract class StandardDataPackage<T extends StandardDataObject> extends AbstractDataPackage<T> {
    /**
     * Общее количество записей в Quik-е
     */
    @JsonProperty
    public long allCount;

    @JsonProperty(value = "items")
    @Override
    public Collection<T> getItems() {
        return super.getItems();
    }

    public T getItem(int index) {
        return super.get(index);
    }

    abstract public T createInstanceFromQuikSource(QuikStandardDataObject quikDataObject);

    public StandardDataPackage() {
        super();
    }

    public StandardDataPackage(QuikStandardDataPackage quikDataPackage) {
        super();
        this.allCount = quikDataPackage.getQuikAllCount();
        final var n = quikDataPackage.size();
        for (int i = 0; i < n; i++) {
            this.getListItems().add(createInstanceFromQuikSource((QuikStandardDataObject)quikDataPackage.get(i)));
        }
    }
}
