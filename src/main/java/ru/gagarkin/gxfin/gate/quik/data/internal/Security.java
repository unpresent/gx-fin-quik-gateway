package ru.gagarkin.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikSecurity;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataObject;

/**
 * Инструмент
 */
public class Security extends StandardDataObject {
    /**
     * Код инструмента
     */
    @JsonProperty
    public String code;

    /**
     * Наименование инструмента
     */
    @JsonProperty
    public String name;

    /**
     * Короткое наименование инструмента
     */
    @JsonProperty
    public String shortName;

    /**
     * Код класса инструментов
     */
    @JsonProperty
    public String classCode;

    /**
     * Наименование класса инструментов
     */
    @JsonProperty
    public String className;

    /**
     * Номинал
     */
    @JsonProperty
    public Double faceValue;

    /**
     * Валюта номинала
     */
    @JsonProperty
    public String faceUnit;

    /**
     * Точность (количество значащих цифр после запятой)
     */
    @JsonProperty
    public String scale;

    /**
     * Дата погашения
     */
    @JsonProperty
    public long maturityDate;

    /**
     * Размер лота
     */
    @JsonProperty
    public double lotSize;

    /**
     * ISIN
     */
    @JsonProperty
    public String isinCode;

    /**
     * Минимальный шаг цены
     */
    @JsonProperty
    public double minPriceStep;

    protected Security() {
        super();
    }

    protected Security(QuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        var sourceDataObject = (QuikSecurity) quikDataObject;
        this.code = sourceDataObject.code;
        this.name = sourceDataObject.name;
        this.shortName = sourceDataObject.shortName;
        this.classCode = sourceDataObject.classCode;
        this.className = sourceDataObject.className;
        this.faceValue = sourceDataObject.faceValue;
        this.faceUnit = sourceDataObject.faceUnit;
        this.scale = sourceDataObject.scale;
        this.maturityDate = sourceDataObject.maturityDate;
        this.lotSize = sourceDataObject.lotSize;
        this.isinCode = sourceDataObject.isinCode;
        this.minPriceStep = sourceDataObject.minPriceStep;
    }
}
