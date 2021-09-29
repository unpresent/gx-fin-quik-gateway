package ru.gx.fin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.data.AbstractDataObject;
import ru.gx.utils.StringUtils;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;

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

    @NotNull
    public static String extractExchangeCode(@Nullable final String sourceExchangeCode, @NotNull final String sourceClassCode) {
        // Определяем код площадки
        var result = sourceExchangeCode;
        if (result == null || StringUtils.isNull(result, "").equals("")) {
            final var clsCode3 = sourceClassCode.substring(0, Math.min(sourceClassCode.length(), 3));
            result = clsCode3.equals("SPB") ? "SPB" : "MICEX";
        }
        return result;
    }
}
