package ru.gx.fin.gate.quik.model.original;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.gx.core.data.AbstractDataObject;

/**
 * Базовый тип для DTO (объектов передачи данных) из Quik-а.
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public abstract class OriginalQuikStandardDataObject extends AbstractDataObject {
    /**
     * Номер записи по порядку
     */
    @JsonProperty(value = "row_index")
    private int rowIndex;
}
