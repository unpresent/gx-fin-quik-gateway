package ru.gxfin.gate.quik.data.income;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Обезличенная сделка
 */
@Getter
@Setter
@EqualsAndHashCode
public class QuikAllTrade extends QuikStandardDataObject {

    /**
     * Номер сделки в торговой системе
     */
    @JsonProperty(value = "trade_num")
    public String tradeNum;

    /**
     * Набор битовых флагов
     */
    @JsonProperty(value = "flags")
    public int flags;

    /**
     * Дата и время
     */
    @JsonProperty(value = "datetime")
    public Date tradeDateTime;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty(value = "exchange_code")
    public String exchangeCode;

    /**
     * Код класса
     */
    @JsonProperty(value = "class_code")
    public String classCode;

    /**
     * Код бумаги заявки
     */
    @JsonProperty(value = "sec_code")
    public String secCode;

    /**
     * Цена
     */
    @JsonProperty(value = "price")
    public BigDecimal price;

    /**
     * Количество бумаг в последней сделке в лотах
     */
    @JsonProperty(value = "qty")
    public BigDecimal quantity;

    /**
     * Объем в денежных средствах
     */
    @JsonProperty(value = "value")
    public BigDecimal value;

    /**
     * Накопленный купонный доход
     */
    @JsonProperty(value = "accruedint")
    public BigDecimal accruedInterest;

    /**
     * Доходность
     */
    @JsonProperty(value = "yield")
    public BigDecimal yield;

    /**
     * Код расчетов
     */
    @JsonProperty(value = "settlecode")
    public String settleCode;

    /**
     * Ставка РЕПО (%)
     */
    @JsonProperty(value = "reporate")
    public BigDecimal repoRate;

    /**
     * Сумма РЕПО
     */
    @JsonProperty(value = "repovalue")
    public BigDecimal repoValue;

    /**
     * Объем выкупа РЕПО
     */
    @JsonProperty(value = "repo2value")
    public BigDecimal repo2Value;

    /**
     * Срок РЕПО в днях
     */
    @JsonProperty(value = "repoterm")
    public int repoTerm;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    @JsonProperty(value = "period")
    public short period;

    /**
     * Открытый интерес
     */
    @JsonProperty(value = "open_interest")
    public int openInterest;
}
