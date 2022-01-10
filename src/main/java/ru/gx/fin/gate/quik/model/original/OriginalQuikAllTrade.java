package ru.gx.fin.gate.quik.model.original;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Обезличенная сделка
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OriginalQuikAllTrade extends OriginalQuikStandardDataObject {

    /**
     * Номер сделки в торговой системе
     */
    @JsonProperty(value = "trade_num")
    private String tradeNum;

    /**
     * Набор битовых флагов
     */
    @JsonProperty(value = "flags")
    private int flags;

    /**
     * Дата и время
     */
    @JsonProperty(value = "datetime")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime tradeDateTime;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty(value = "exchange_code")
    private String exchangeCode;

    /**
     * Код класса
     */
    @JsonProperty(value = "class_code")
    private String classCode;

    /**
     * Код бумаги заявки
     */
    @JsonProperty(value = "sec_code")
    private String secCode;

    /**
     * Цена
     */
    @JsonProperty(value = "price")
    private BigDecimal price;

    /**
     * Количество бумаг в последней сделке в лотах
     */
    @JsonProperty(value = "qty")
    private BigDecimal quantity;

    /**
     * Объем в денежных средствах
     */
    @JsonProperty(value = "value")
    private BigDecimal value;

    /**
     * Накопленный купонный доход
     */
    @JsonProperty(value = "accruedint")
    private BigDecimal accruedInterest;

    /**
     * Доходность
     */
    @JsonProperty(value = "yield")
    private BigDecimal yield;

    /**
     * Код расчетов
     */
    @JsonProperty(value = "settlecode")
    private String settleCode;

    /**
     * Ставка РЕПО (%)
     */
    @JsonProperty(value = "reporate")
    private BigDecimal repoRate;

    /**
     * Сумма РЕПО
     */
    @JsonProperty(value = "repovalue")
    private BigDecimal repoValue;

    /**
     * Объем выкупа РЕПО
     */
    @JsonProperty(value = "repo2value")
    private BigDecimal repo2Value;

    /**
     * Срок РЕПО в днях
     */
    @JsonProperty(value = "repoterm")
    private int repoTerm;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    @JsonProperty(value = "period")
    private short period;

    /**
     * Открытый интерес
     */
    @JsonProperty(value = "open_interest")
    private int openInterest;
}
