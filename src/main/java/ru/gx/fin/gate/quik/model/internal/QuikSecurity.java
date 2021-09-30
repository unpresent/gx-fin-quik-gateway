package ru.gx.fin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import ru.gx.fin.gate.quik.model.memdata.QuikSecuritiesMemoryRepository;
import ru.gx.fin.gate.quik.model.original.OriginalQuikSecurity;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;

import java.math.BigDecimal;

/**
 * Инструмент
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class, resolver = QuikSecuritiesMemoryRepository.IdResolver.class)
public class QuikSecurity extends QuikStandardDataObject {
    @NotNull
    private String id;

    /**
     * Вычисление идентификатора инструмента.
     */
    protected void calcId() {
        this.id = this.code + ":" + this.classCode;
    }

    /**
     * Код инструмента
     */
    private String code;

    /**
     * Наименование инструмента
     */
    private String name;

    /**
     * Короткое наименование инструмента
     */
    private String shortName;

    /**
     * Код класса инструментов
     */
    private String classCode;

    /**
     * Наименование класса инструментов
     */
    private String className;

    /**
     * Номинал
     */
    private BigDecimal faceValue;

    /**
     * Валюта номинала
     */
    private String faceUnit;

    /**
     * Точность (количество значащих цифр после запятой)
     */
    private int scale;

    /**
     * Дата погашения
     */
    private long maturityDate;

    /**
     * Размер лота
     */
    private BigDecimal lotSize;

    /**
     * ISIN
     */
    private String isinCode;

    /**
     * Минимальный шаг цены
     */
    private BigDecimal minPriceStep;

    public QuikSecurity(@NotNull final OriginalQuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        final var sourceDataObject = (OriginalQuikSecurity) quikDataObject;
        this.code = sourceDataObject.getCode();
        this.classCode = sourceDataObject.getClassCode();
        // Определяем идентификатор - составной
        calcId();
        this.name = sourceDataObject.getName();
        this.shortName = sourceDataObject.getShortName();
        this.className = sourceDataObject.getClassName();
        this.faceValue = sourceDataObject.getFaceValue();
        this.faceUnit = sourceDataObject.getFaceUnit();
        this.scale = sourceDataObject.getScale();
        this.maturityDate = sourceDataObject.getMaturityDate();
        this.lotSize = sourceDataObject.getLotSize();
        this.isinCode = sourceDataObject.getIsinCode();
        this.minPriceStep = sourceDataObject.getMinPriceStep();
    }
}
