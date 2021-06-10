package ru.gagarkin.gxfin.gate.quik.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StandardDtoObject extends AbstractDtoObject {
    /**
     * Номер записи по порядку
     */
    @JsonProperty(value = "row_index")
    public int rowIndex;
}
