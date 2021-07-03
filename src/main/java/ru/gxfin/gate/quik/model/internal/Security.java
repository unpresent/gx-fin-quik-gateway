package ru.gxfin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.gxfin.gate.quik.model.income.QuikSecurity;
import ru.gxfin.gate.quik.model.income.QuikStandardDataObject;

import java.math.BigDecimal;

/**
 * Инструмент
 */
@Getter
@Setter
@EqualsAndHashCode
public class Security extends StandardDataObject {
    /**
     * Код инструмента
     */
    @JsonProperty
    private String code;

    /**
     * Наименование инструмента
     */
    @JsonProperty
    private String name;

    /**
     * Короткое наименование инструмента
     */
    @JsonProperty
    private String shortName;

    /**
     * Код класса инструментов
     */
    @JsonProperty
    private String classCode;

    /**
     * Наименование класса инструментов
     */
    @JsonProperty
    private String className;

    /**
     * Номинал
     */
    @JsonProperty
    private BigDecimal faceValue;

    /**
     * Валюта номинала
     */
    @JsonProperty
    private String faceUnit;

    /**
     * Точность (количество значащих цифр после запятой)
     */
    @JsonProperty
    private String scale;

    /**
     * Дата погашения
     */
    @JsonProperty
    private long maturityDate;

    /**
     * Размер лота
     */
    @JsonProperty
    private BigDecimal lotSize;

    /**
     * ISIN
     */
    @JsonProperty
    private String isinCode;

    /**
     * Минимальный шаг цены
     */
    @JsonProperty
    private BigDecimal minPriceStep;

    public Security() {
        super();
    }

    public Security(QuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        final var sourceDataObject = (QuikSecurity) quikDataObject;
        this.code = sourceDataObject.getCode();
        this.name = sourceDataObject.getName();
        this.shortName = sourceDataObject.getShortName();
        this.classCode = sourceDataObject.getClassCode();
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
