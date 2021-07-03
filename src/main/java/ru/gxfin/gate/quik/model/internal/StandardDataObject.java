package ru.gxfin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gxfin.common.data.AbstractDataObject;
import ru.gxfin.gate.quik.model.income.QuikStandardDataObject;

public abstract class StandardDataObject extends AbstractDataObject {
    /**
     * Номер записи по порядку
     */
    @JsonProperty
    public int rowIndex;

    public StandardDataObject() {
        super();
    }

    protected StandardDataObject(QuikStandardDataObject quikDataObject) {
        super();
        this.rowIndex = quikDataObject.getRowIndex();
    }
}
