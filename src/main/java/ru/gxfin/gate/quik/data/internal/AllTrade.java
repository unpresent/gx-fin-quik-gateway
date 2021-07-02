package ru.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.gxfin.gate.quik.data.income.QuikAllTrade;
import ru.gxfin.gate.quik.data.income.QuikStandardDataObject;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Обезличенная сделка
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AllTrade extends StandardDataObject {

    /**
     * Номер сделки в торговой системе
     */
    @JsonProperty
    private String tradeNum;

    /**
     * Набор битовых флагов
     */
    @JsonProperty
    private int flags;

    /**
     * Дата и время
     */
    @JsonProperty
    private LocalDateTime tradeDateTime;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty
    private String exchangeCode;

    /**
     * Код класса
     */
    @JsonProperty
    private String classCode;

    /**
     * Код бумаги заявки
     */
    @JsonProperty
    private String secCode;

    /**
     * Цена
     */
    @JsonProperty
    private BigDecimal price;

    /**
     * Количество бумаг в последней сделке в лотах
     */
    @JsonProperty
    private BigDecimal quantity;

    /**
     * Объем в денежных средствах
     */
    @JsonProperty
    private BigDecimal value;

    /**
     * Накопленный купонный доход
     */
    @JsonProperty
    private BigDecimal accruedInterest;

    /**
     * Доходность
     */
    @JsonProperty
    private BigDecimal yield;

    /**
     * Код расчетов
     */
    @JsonProperty
    private String settleCode;

    /**
     * Ставка РЕПО (%)
     */
    @JsonProperty
    private BigDecimal repoRate;

    /**
     * Сумма РЕПО
     */
    @JsonProperty
    private BigDecimal repoValue;

    /**
     * Объем выкупа РЕПО
     */
    @JsonProperty
    private BigDecimal repo2Value;

    /**
     * Срок РЕПО в днях
     */
    @JsonProperty
    private int repoTerm;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    @JsonProperty
    private short period;

    /**
     * Открытый интерес
     */
    @JsonProperty
    private int openInterest;

    public AllTrade() {
        super();
    }

    public AllTrade(QuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        final var sourceDataObject = (QuikAllTrade) quikDataObject;
        this.tradeNum = sourceDataObject.tradeNum;
        this.flags = sourceDataObject.flags;
        this.tradeDateTime = sourceDataObject.tradeDateTime
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
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
