package ru.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.gxfin.gate.quik.data.income.QuikSecurity;
import ru.gxfin.gate.quik.data.income.QuikStandardDataObject;

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
    private Double faceValue;

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
    private double lotSize;

    /**
     * ISIN
     */
    @JsonProperty
    private String isinCode;

    /**
     * Минимальный шаг цены
     */
    @JsonProperty
    private double minPriceStep;

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
