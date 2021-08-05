package ru.gxfin.gate.quik.model.original;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * Инструмент
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class OriginalQuikSecurity extends OriginalQuikStandardDataObject {
    /**
     * Код инструмента
     */
    @JsonProperty(value = "code")
    private String code;

    /**
     * Наименование инструмента
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Короткое наименование инструмента
     */
    @JsonProperty(value = "short_name")
    private String shortName;

    /**
     * Код класса инструментов
     */
    @JsonProperty(value = "class_code")
    private String classCode;

    /**
     * Наименование класса инструментов
     */
    @JsonProperty(value = "class_name")
    private String className;

    /**
     * Номинал
     */
    @JsonProperty(value = "face_value")
    private BigDecimal faceValue;

    /**
     * Валюта номинала
     */
    @JsonProperty(value = "face_unit")
    private String faceUnit;

    /**
     * Точность (количество значащих цифр после запятой)
     */
    @JsonProperty(value = "scale")
    private int scale;

    /**
     * Дата погашения
     */
    @JsonProperty(value = "mat_date")
    private long maturityDate;

    /**
     * Размер лота
     */
    @JsonProperty(value = "lot_size")
    private BigDecimal lotSize;

    /**
     * ISIN
     */
    @JsonProperty(value = "isin_code")
    private String isinCode;

    /**
     * Минимальный шаг цены
     */
    @JsonProperty(value = "min_price_step")
    private BigDecimal minPriceStep;
}