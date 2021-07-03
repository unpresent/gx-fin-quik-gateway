package ru.gxfin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.gxfin.common.utils.BigDecimalUtils;
import ru.gxfin.common.utils.StringUtils;
import ru.gxfin.gate.quik.model.income.QuikAllTrade;
import ru.gxfin.gate.quik.model.income.QuikStandardDataObject;

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
        this.tradeNum = sourceDataObject.getTradeNum();
        this.flags = sourceDataObject.getFlags();
        this.tradeDateTime = sourceDataObject.getTradeDateTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        this.exchangeCode = sourceDataObject.getExchangeCode();
        this.classCode = StringUtils.nullIf(sourceDataObject.getClassCode(), "");
        this.secCode = StringUtils.nullIf(sourceDataObject.getSecCode(), "");
        this.price = sourceDataObject.getPrice();
        this.quantity = sourceDataObject.getQuantity();
        this.value = sourceDataObject.getValue();
        this.accruedInterest = BigDecimalUtils.nullIf(sourceDataObject.getAccruedInterest(), BigDecimal.ZERO);
        this.yield = BigDecimalUtils.nullIf(sourceDataObject.getYield(), BigDecimal.ZERO);
        this.settleCode = StringUtils.nullIf(sourceDataObject.getSettleCode(), "");
        this.repoRate = BigDecimalUtils.nullIf(sourceDataObject.getRepoRate(), BigDecimal.ZERO);
        this.repoValue = BigDecimalUtils.nullIf(sourceDataObject.getRepoValue(), BigDecimal.ZERO);
        this.repo2Value = BigDecimalUtils.nullIf(sourceDataObject.getRepo2Value(), BigDecimal.ZERO);
        this.repoTerm = sourceDataObject.getRepoTerm();
        this.period = sourceDataObject.getPeriod();
        this.openInterest = sourceDataObject.getOpenInterest();
    }
}
