package ru.gagarkin.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikAllTrade;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataObject;

import java.util.Date;

/**
 * Обезличенная сделка
 */
public class AllTrade extends StandardDataObject {
    /**
     * Номер сделки в торговой системе
     */
    @JsonProperty
    public String tradeNum;

    /**
     * Набор битовых флагов
     */
    @JsonProperty
    public int flags;

    /**
     * Дата и время
     */
    @JsonProperty
    public Date tradeDateTime;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty
    public String exchangeCode;

    /**
     * Код класса
     */
    @JsonProperty
    public String classCode;

    /**
     * Код бумаги заявки
     */
    @JsonProperty
    public String secCode;

    /**
     * Цена
     */
    @JsonProperty
    public double price;

    /**
     * Количество бумаг в последней сделке в лотах
     */
    @JsonProperty
    public double quantity;

    /**
     * Объем в денежных средствах
     */
    @JsonProperty
    public double value;

    /**
     * Накопленный купонный доход
     */
    @JsonProperty
    public double accruedInterest;

    /**
     * Доходность
     */
    @JsonProperty
    public double yield;

    /**
     * Код расчетов
     */
    @JsonProperty
    public String settleCode;

    /**
     * Ставка РЕПО (%)
     */
    @JsonProperty
    public double repoRate;

    /**
     * Сумма РЕПО
     */
    @JsonProperty
    public double repoValue;

    /**
     * Объем выкупа РЕПО
     */
    @JsonProperty
    public double repo2Value;

    /**
     * Срок РЕПО в днях
     */
    @JsonProperty
    public int repoTerm;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    @JsonProperty
    public short period;

    /**
     * Открытый интерес
     */
    @JsonProperty
    public int openInterest;

    protected AllTrade() {
        super();
    }

    protected AllTrade(QuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        var sourceDataObject = (QuikAllTrade) quikDataObject;
        this.tradeNum = sourceDataObject.tradeNum;
        this.flags = sourceDataObject.flags;
        this.tradeDateTime = sourceDataObject.tradeDateTime;
        this.exchangeCode = sourceDataObject.exchangeCode;
        this.classCode = sourceDataObject.classCode;
        this.secCode = sourceDataObject.secCode;
        this.price = sourceDataObject.price;
        this.quantity = sourceDataObject.quantity;
        this.value = sourceDataObject.value;
        this.accruedInterest = sourceDataObject.accruedInterest;
        this.yield = sourceDataObject.yield;
        this.settleCode = sourceDataObject.settleCode;
        this.repoRate = sourceDataObject.repoRate;
        this.repoValue = sourceDataObject.repoValue;
        this.repo2Value = sourceDataObject.repo2Value;
        this.repoTerm = sourceDataObject.repoTerm;
        this.period = sourceDataObject.period;
        this.openInterest = sourceDataObject.openInterest;
    }
}
