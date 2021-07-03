package ru.gxfin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.gxfin.common.utils.BigDecimalUtils;
import ru.gxfin.common.utils.StringUtils;
import ru.gxfin.gate.quik.model.income.QuikOrder;
import ru.gxfin.gate.quik.model.income.QuikStandardDataObject;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Заявка
 */
@Getter
@Setter
@EqualsAndHashCode
public class Order extends StandardDataObject {
    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty
    private String orderNum;

    /**
     * Набор битовых флагов
     */
    @JsonProperty
    private int flags;

    /**
     * Комментарий, обычно: <код клиента>/<номер поручения>
     */
    @JsonProperty
    private String brokerRef;

    /**
     * Идентификатор трейдера
     */
    @JsonProperty
    private String userId;

    /**
     * Идентификатор фирмы
     */
    @JsonProperty
    private String firmId;

    /**
     * Торговый счет
     */
    @JsonProperty
    private String account;

    /**
     * Цена
     */
    @JsonProperty
    private BigDecimal price;

    /**
     * Количество в лотах
     */
    @JsonProperty
    private BigDecimal quantity;

    /**
     * Остаток
     */
    @JsonProperty
    private BigDecimal balance;

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
     * Идентификатор транзакции
     */
    @JsonProperty
    private long transactionId;

    /**
     * Код клиента
     */
    @JsonProperty
    private String clientCode;

    /**
     * Цена выкупа
     */
    @JsonProperty
    private BigDecimal price2;

    /**
     * Код расчетов
     */
    @JsonProperty
    private String settleCode;

    /**
     * Идентификатор пользователя
     */
    @JsonProperty
    private long uid;

    /**
     * Идентификатор пользователя, снявшего заявку
     */
    @JsonProperty
    private long canceledUid;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty
    private String exchangeCode;

    /**
     * Время активации
     */
    @JsonProperty("activation_time")
    private Date activationTime;

    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty
    private long linkedOrder;

    /**
     * Дата окончания срока действия заявки
     */
    @JsonProperty
    private long expiry;

    /**
     * Код бумаги заявки
     */
    @JsonProperty
    private String secCode;

    /**
     * Код класса заявки
     */
    @JsonProperty
    private String classCode;

    /**
     * Дата и время
     */
    @JsonProperty
    private Date tradeDateTime;

    /**
     * Дата и время снятия заявки
     */
    @JsonProperty
    private Date withdrawDateTime;

    /**
     * Идентификатор расчетного счета/кода в клиринговой организации
     */
    @JsonProperty
    private String bankAccountId;

    /**
     * Способ указания объема заявки. Возможные значения:
     * «0» – по количеству,
     * «1» – по объему
     */
    @JsonProperty
    private byte valueEntryType;

    /**
     * Срок РЕПО, в календарных днях
     */
    @JsonProperty
    private int repoTerm;

    /**
     * Сумма РЕПО на текущую дату. Отображается с точностью 2 знака
     */
    @JsonProperty
    private BigDecimal repoValue;

    /**
     * Объём сделки выкупа РЕПО. Отображается с точностью 2 знака
     */
    @JsonProperty
    private BigDecimal repo2Value;

    /**
     * Остаток суммы РЕПО за вычетом суммы привлеченных
     * или предоставленных по сделке РЕПО денежных средств в неисполненной части заявки,
     * по состоянию на текущую дату.
     * Отображается с точностью 2 знака
     */
    @JsonProperty
    private BigDecimal repoValueBalance;

    /**
     * Начальный дисконт, в %
     */
    @JsonProperty
    private BigDecimal startDiscount;

    /**
     * Причина отклонения заявки брокером
     */
    @JsonProperty
    private String rejectRreason;

    /**
     * Битовое поле для получения специфических параметров с западных площадок
     */
    @JsonProperty
    private int extOrderFlags;

    /**
     * Минимально допустимое количество, которое можно указать в заявке по данному инструменту.
     * Если имеет значение «0», значит ограничение по количеству не задано
     */
    @JsonProperty
    private BigDecimal minQuantity;

    /**
     * Тип исполнения заявки. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty
    private int execType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty
    private int sideQualifier;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty
    private int accountType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty
    private BigDecimal capacity;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty
    private byte passiveOnlyOrder;

    /**
     * Видимое количество. Параметр айсберг-заявок, для обычных заявок выводится значение: «0»
     */
    @JsonProperty
    private BigDecimal visible;

    public Order() {
        super();
    }

    public Order(QuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        final var sourceDataObject = (QuikOrder) quikDataObject;
        this.orderNum = sourceDataObject.getOrderNum();
        this.flags = sourceDataObject.getFlags();
        this.brokerRef = StringUtils.nullIf(sourceDataObject.getBrokerRef(), "");
        this.userId = StringUtils.nullIf(sourceDataObject.getUserId(), "");
        this.firmId = StringUtils.nullIf(sourceDataObject.getFirmId(), "");
        this.account = StringUtils.nullIf(sourceDataObject.getAccount(), "");
        this.price = sourceDataObject.getPrice();
        this.quantity = sourceDataObject.getQuantity();
        this.balance = BigDecimalUtils.nullIf(sourceDataObject.getBalance(), BigDecimal.ZERO);;
        this.value = sourceDataObject.getValue();
        this.accruedInterest = BigDecimalUtils.nullIf(sourceDataObject.getAccruedInterest(), BigDecimal.ZERO);
        this.yield = BigDecimalUtils.nullIf(sourceDataObject.getYield(), BigDecimal.ZERO);
        this.transactionId = sourceDataObject.getTransactionId();
        this.clientCode = StringUtils.nullIf(sourceDataObject.getClientCode(), "");
        this.price2 = BigDecimalUtils.nullIf(sourceDataObject.getPrice2(), BigDecimal.ZERO);
        this.settleCode = sourceDataObject.getSettleCode();
        this.uid = sourceDataObject.getUid();
        this.canceledUid = sourceDataObject.getCanceledUid();
        this.exchangeCode = sourceDataObject.getExchangeCode();
        this.activationTime = sourceDataObject.getActivationTime();
        this.linkedOrder = sourceDataObject.getLinkedOrder();
        this.expiry = sourceDataObject.getExpiry();
        this.secCode = sourceDataObject.getSecCode();
        this.classCode = sourceDataObject.getClassCode();
        this.tradeDateTime = sourceDataObject.getTradeDateTime();
        this.withdrawDateTime = sourceDataObject.getWithdrawDateTime();
        this.bankAccountId = StringUtils.nullIf(sourceDataObject.getBankAccountId(), "");
        this.valueEntryType = sourceDataObject.getValueEntryType();
        this.repoTerm = sourceDataObject.getRepoTerm();
        this.repoValue = BigDecimalUtils.nullIf(sourceDataObject.getRepoValue(), BigDecimal.ZERO);
        this.repo2Value = BigDecimalUtils.nullIf(sourceDataObject.getRepo2Value(), BigDecimal.ZERO);
        this.repoValueBalance = BigDecimalUtils.nullIf(sourceDataObject.getRepoValueBalance(), BigDecimal.ZERO);
        this.startDiscount = BigDecimalUtils.nullIf(sourceDataObject.getStartDiscount(), BigDecimal.ZERO);
        this.rejectRreason = StringUtils.nullIf(sourceDataObject.getRejectRreason(), "");
        this.extOrderFlags = sourceDataObject.getExtOrderFlags();
        this.minQuantity = BigDecimalUtils.nullIf(sourceDataObject.getMinQuantity(), BigDecimal.ZERO);
        this.execType = sourceDataObject.getExecType();
        this.sideQualifier = sourceDataObject.getSideQualifier();
        this.accountType = sourceDataObject.getAccountType();
        this.capacity = BigDecimalUtils.nullIf(sourceDataObject.getCapacity(), BigDecimal.ZERO);
        this.passiveOnlyOrder = sourceDataObject.getPassiveOnlyOrder();
        this.visible = sourceDataObject.getVisible();
    }
}
