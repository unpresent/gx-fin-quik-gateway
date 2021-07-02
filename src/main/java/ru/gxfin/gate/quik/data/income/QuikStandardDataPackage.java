package ru.gxfin.gate.quik.data.income;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.gxfin.common.data.AbstractDataPackage;

import java.util.Collection;

@EqualsAndHashCode
public abstract class QuikStandardDataPackage<T extends QuikStandardDataObject> extends AbstractDataPackage<T> {
    @JsonProperty(value = "package_size")
    @Getter
    @Setter
    private int quikPackageSize;

    /**
     * Общее количество записей в Quik-е
     */
    @JsonProperty(value = "all_count")
    @Getter
    @Setter
    private long quikAllCount;

    @JsonProperty(value = "rows")
    @Override
    public Collection<T> getItems() {
        return super.getItems();
    }

    public T getRow(int index) {
        return super.get(index);
    }
}
