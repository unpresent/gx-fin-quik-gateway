package ru.gagarkin.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikDeal;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikOrder;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataObject;

import java.util.Date;

/**
 * Заявка
 */
public class Order extends StandardDataObject {
    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty
    public String orderNum;

    /**
     * Набор битовых флагов
     */
    @JsonProperty
    public int flags;

    /**
     * Комментарий, обычно: <код клиента>/<номер поручения>
     */
    @JsonProperty
    public String brokerRef;

    /**
     * Идентификатор трейдера
     */
    @JsonProperty
    public String userId;

    /**
     * Идентификатор фирмы
     */
    @JsonProperty
    public String firmId;

    /**
     * Торговый счет
     */
    @JsonProperty
    public String account;

    /**
     * Цена
     */
    @JsonProperty
    public double price;

    /**
     * Количество в лотах
     */
    @JsonProperty
    public double quantity;

    /**
     * Остаток
     */
    @JsonProperty
    public double balance;

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
     * Идентификатор транзакции
     */
    @JsonProperty
    public long transactionId;

    /**
     * Код клиента
     */
    @JsonProperty
    public String clientCode;

    /**
     * Цена выкупа
     */
    @JsonProperty
    public double price2;

    /**
     * Код расчетов
     */
    @JsonProperty
    public String settleCode;

    /**
     * Идентификатор пользователя
     */
    @JsonProperty
    public long uid;

    /**
     * Идентификатор пользователя, снявшего заявку
     */
    @JsonProperty
    public long canceledUid;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty
    public String exchangeCode;

    /**
     * Время активации
     */
    @JsonProperty
    public Date activation_time;

    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty
    public long linkedOrder;

    /**
     * Дата окончания срока действия заявки
     */
    @JsonProperty
    public long expiry;

    /**
     * Код бумаги заявки
     */
    @JsonProperty
    public String secCode;

    /**
     * Код класса заявки
     */
    @JsonProperty
    public String classCode;

    /**
     * Дата и время
     */
    @JsonProperty
    public Date tradeDateTime;

    /**
     * Дата и время снятия заявки
     */
    @JsonProperty
    public Date withdrawDateTime;

    /**
     * Идентификатор расчетного счета/кода в клиринговой организации
     */
    @JsonProperty
    public String bankAccountId;

    /**
     * Способ указания объема заявки. Возможные значения:
     * «0» – по количеству,
     * «1» – по объему
     */
    @JsonProperty
    public byte valueEntryType;

    /**
     * Срок РЕПО, в календарных днях
     */
    @JsonProperty
    public int repoTerm;

    /**
     * Сумма РЕПО на текущую дату. Отображается с точностью 2 знака
     */
    @JsonProperty
    public double repoValue;

    /**
     * Объём сделки выкупа РЕПО. Отображается с точностью 2 знака
     */
    @JsonProperty
    public double repo2Value;

    /**
     * Остаток суммы РЕПО за вычетом суммы привлеченных
     * или предоставленных по сделке РЕПО денежных средств в неисполненной части заявки,
     * по состоянию на текущую дату.
     * Отображается с точностью 2 знака
     */
    @JsonProperty
    public double repoValueBalance;

    /**
     * Начальный дисконт, в %
     */
    @JsonProperty
    public double startDiscount;

    /**
     * Причина отклонения заявки брокером
     */
    @JsonProperty
    public String rejectRreason;

    /**
     * Битовое поле для получения специфических параметров с западных площадок
     */
    @JsonProperty
    public int extOrderFlags;

    /**
     * Минимально допустимое количество, которое можно указать в заявке по данному инструменту.
     * Если имеет значение «0», значит ограничение по количеству не задано
     */
    @JsonProperty
    public double minQuantity;

    /**
     * Тип исполнения заявки. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty
    public int execType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty
    public int sideQualifier;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty
    public int accountType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty
    public double capacity;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty
    public byte passiveOnlyOrder;

    /**
     * Видимое количество. Параметр айсберг-заявок, для обычных заявок выводится значение: «0»
     */
    @JsonProperty
    public double visible;

    protected Order() {
        super();
    }

    protected Order(QuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        var sourceDataObject = (QuikOrder) quikDataObject;
        this.orderNum = sourceDataObject.orderNum;
        this.flags = sourceDataObject.flags;
        this.brokerRef = sourceDataObject.brokerRef;
        this.userId = sourceDataObject.userId;
        this.firmId = sourceDataObject.firmId;
        this.account = sourceDataObject.account;
        this.price = sourceDataObject.price;
        this.quantity = sourceDataObject.quantity;
        this.balance = sourceDataObject.balance;
        this.value = sourceDataObject.value;
        this.accruedInterest = sourceDataObject.accruedInterest;
        this.yield = sourceDataObject.yield;
        this.transactionId = sourceDataObject.transactionId;
        this.clientCode = sourceDataObject.clientCode;
        this.price2 = sourceDataObject.price2;
        this.settleCode = sourceDataObject.settleCode;
        this.uid = sourceDataObject.uid;
        this.canceledUid = sourceDataObject.canceledUid;
        this.exchangeCode = sourceDataObject.exchangeCode;
        this.activation_time = sourceDataObject.activation_time;
        this.linkedOrder = sourceDataObject.linkedOrder;
        this.expiry = sourceDataObject.expiry;
        this.secCode = sourceDataObject.secCode;
        this.classCode = sourceDataObject.classCode;
        this.tradeDateTime = sourceDataObject.tradeDateTime;
        this.withdrawDateTime = sourceDataObject.withdrawDateTime;
        this.bankAccountId = sourceDataObject.bankAccountId;
        this.valueEntryType = sourceDataObject.valueEntryType;
        this.repoTerm = sourceDataObject.repoTerm;
        this.repoValue = sourceDataObject.repoValue;
        this.repo2Value = sourceDataObject.repo2Value;
        this.repoValueBalance = sourceDataObject.repoValueBalance;
        this.startDiscount = sourceDataObject.startDiscount;
        this.rejectRreason = sourceDataObject.rejectRreason;
        this.extOrderFlags = sourceDataObject.extOrderFlags;
        this.minQuantity = sourceDataObject.minQuantity;
        this.execType = sourceDataObject.execType;
        this.sideQualifier = sourceDataObject.sideQualifier;
        this.accountType = sourceDataObject.accountType;
        this.capacity = sourceDataObject.capacity;
        this.passiveOnlyOrder = sourceDataObject.passiveOnlyOrder;
        this.visible = sourceDataObject.visible;
    }
}
