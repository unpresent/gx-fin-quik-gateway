package ru.gagarkin.gxfin.gate.quik.data.income;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gagarkin.gxfin.common.data.AbstractDataPackage;

import java.util.Collection;

public abstract class QuikStandardDataPackage<T extends QuikStandardDataObject> extends AbstractDataPackage<T> {
    @JsonProperty(value = "package_size")
    public int quikPackageSize;

    /**
     * Общее количество записей в Quik-е
     */
    @JsonProperty(value = "all_count")
    public long quikAllCount;

    @JsonProperty(value = "rows")
    @Override
    public Collection<T> getItems() {
        return super.getItems();
    }

    public T getRow(int index) {
        return super.get(index);
    }
}
