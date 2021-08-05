package ru.gxfin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.gxfin.common.data.AbstractDataObject;
import ru.gxfin.common.utils.StringUtils;
import ru.gxfin.gate.quik.model.original.OriginalQuikStandardDataObject;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public abstract class QuikStandardDataObject extends AbstractDataObject {
    /**
     * Номер записи по порядку
     */
    @JsonProperty
    private int rowIndex;

    protected QuikStandardDataObject() {
        super();
    }

    protected QuikStandardDataObject(OriginalQuikStandardDataObject quikDataObject) {
        super();
        this.rowIndex = quikDataObject.getRowIndex();
    }

    public static String extractExchangeCode(String sourceExchangeCode, String sourceClassCode) {
        // Определяем код площадки
        var result = sourceExchangeCode;
        if (StringUtils.isNull(result, "").equals("")) {
            final var clsCode3 = sourceClassCode.substring(0, Math.min(sourceClassCode.length(), 3));
            result = clsCode3.equals("SPB") ? "SPB" : "MICEX";
        }
        return result;
    }
}
