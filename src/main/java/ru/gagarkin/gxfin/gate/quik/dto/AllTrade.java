package ru.gagarkin.gxfin.gate.quik.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Обезличенная сделка
 */
public class AllTrade extends StandardDtoObject {
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
    public double price;

    /**
     * Количество бумаг в последней сделке в лотах
     */
    @JsonProperty(value = "qty")
    public double quantity;

    /**
     * Объем в денежных средствах
     */
    @JsonProperty(value = "value")
    public double value;

    /**
     * Накопленный купонный доход
     */
    @JsonProperty(value = "accruedint")
    public double accruedInterest;

    /**
     * Доходность
     */
    @JsonProperty(value = "yield")
    public double yield;

    /**
     * Код расчетов
     */
    @JsonProperty(value = "settlecode")
    public String settleCode;

    /**
     * Ставка РЕПО (%)
     */
    @JsonProperty(value = "reporate")
    public double repoRate;

    /**
     * Сумма РЕПО
     */
    @JsonProperty(value = "repovalue")
    public double repoValue;

    /**
     * Объем выкупа РЕПО
     */
    @JsonProperty(value = "repo2value")
    public double repo2Value;

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
