package ru.gagarkin.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gagarkin.gxfin.common.data.AbstractDataPackage;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataObject;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataPackage;

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
        this.allCount = quikDataPackage.quikAllCount;
        var n = quikDataPackage.size();
        for (int i = 0; i < n; i++) {
            this.getListItems().add(createInstanceFromQuikSource((QuikStandardDataObject)quikDataPackage.get(i)));
        }
    }
}
