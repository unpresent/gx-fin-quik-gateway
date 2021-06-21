package ru.gagarkin.gxfin.gate.quik.data.income;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Инструмент
 */
public class QuikSecurity extends QuikStandardDataObject {
    /**
     * Код инструмента
     */
    @JsonProperty(value = "code")
    public String code;

    /**
     * Наименование инструмента
     */
    @JsonProperty(value = "name")
    public String name;

    /**
     * Короткое наименование инструмента
     */
    @JsonProperty(value = "short_name")
    public String shortName;

    /**
     * Код класса инструментов
     */
    @JsonProperty(value = "class_code")
    public String classCode;

    /**
     * Наименование класса инструментов
     */
    @JsonProperty(value = "class_name")
    public String className;

    /**
     * Номинал
     */
    @JsonProperty(value = "face_value")
    public Double faceValue;

    /**
     * Валюта номинала
     */
    @JsonProperty(value = "face_unit")
    public String faceUnit;

    /**
     * Точность (количество значащих цифр после запятой)
     */
    @JsonProperty(value = "scale")
    public String scale;

    /**
     * Дата погашения
     */
    @JsonProperty(value = "mat_date")
    public long maturityDate;

    /**
     * Размер лота
     */
    @JsonProperty(value = "lot_size")
    public double lotSize;

    /**
     * ISIN
     */
    @JsonProperty(value = "isin_code")
    public String isinCode;

    /**
     * Минимальный шаг цены
     */
    @JsonProperty(value = "min_price_step")
    public double minPriceStep;
}
