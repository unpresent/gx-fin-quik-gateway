package ru.gagarkin.gxfin.gate.quik.data.income;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gagarkin.gxfin.common.data.AbstractDataObject;

/**
 * Базовый тип для DTO (объектов передачи данных) из Quik-а.
 */
public class QuikStandardDataObject extends AbstractDataObject {
    /**
     * Номер записи по порядку
     */
    private int rowIndex;

    @JsonProperty(value = "row_index")
    public int getRowIndex() {
        return this.rowIndex;
    }
    @JsonProperty(value = "row_index")
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
}
