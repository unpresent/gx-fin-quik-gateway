package ru.gx.fin.gate.quik.model.original;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.AbstractDataPackage;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
public abstract class OriginalQuikStandardDataPackage<T extends OriginalQuikStandardDataObject> extends AbstractDataPackage<T> {
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
    @NotNull
    public Collection<T> getObjects() {
        return super.getObjects();
    }

    public T getRow(int index) {
        return super.get(index);
    }
}
