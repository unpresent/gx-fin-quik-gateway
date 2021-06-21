package ru.gagarkin.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gagarkin.gxfin.common.data.AbstractDataObject;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataObject;

public abstract class StandardDataObject extends AbstractDataObject {
    /**
     * Номер записи по порядку
     */
    @JsonProperty
    public int rowIndex;

    protected StandardDataObject() {
        super();
    }

    protected StandardDataObject(QuikStandardDataObject quikDataObject) {
        super();
        this.rowIndex = quikDataObject.getRowIndex();
    }
}
