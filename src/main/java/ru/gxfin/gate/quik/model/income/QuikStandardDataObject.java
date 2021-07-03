package ru.gxfin.gate.quik.model.income;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.gxfin.common.data.AbstractDataObject;

/**
 * Базовый тип для DTO (объектов передачи данных) из Quik-а.
 */
@Getter
@Setter
@EqualsAndHashCode
public class QuikStandardDataObject extends AbstractDataObject {
    /**
     * Номер записи по порядку
     */
    @JsonProperty(value = "row_index")
    private int rowIndex;
}
