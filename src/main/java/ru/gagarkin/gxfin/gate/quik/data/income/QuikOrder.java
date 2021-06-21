package ru.gagarkin.gxfin.gate.quik.data.income;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Заявка
 */
public class QuikOrder extends QuikStandardDataObject {
    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty(value = "order_num")
    public String orderNum;

    /**
     * Набор битовых флагов
     */
    @JsonProperty(value = "flags")
    public int flags;

    /**
     * Комментарий, обычно: <код клиента>/<номер поручения>
     */
    @JsonProperty(value = "brokerref")
    public String brokerRef;

    /**
     * Идентификатор трейдера
     */
    @JsonProperty(value = "userid")
    public String userId;

    /**
     * Идентификатор фирмы
     */
    @JsonProperty(value = "firmid")
    public String firmId;

    /**
     * Торговый счет
     */
    @JsonProperty(value = "account")
    public String account;

    /**
     * Цена
     */
    @JsonProperty(value = "price")
    public double price;

    /**
     * Количество в лотах
     */
    @JsonProperty(value = "qty")
    public double quantity;

    /**
     * Остаток
     */
    @JsonProperty(value = "balance")
    public double balance;

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
     * Идентификатор транзакции
     */
    @JsonProperty(value = "trans_id")
    public long transactionId;

    /**
     * Код клиента
     */
    @JsonProperty(value = "client_code")
    public String clientCode;

    /**
     * Цена выкупа
     */
    @JsonProperty(value = "price2")
    public double price2;

    /**
     * Код расчетов
     */
    @JsonProperty(value = "settlecode")
    public String settleCode;

    /**
     * Идентификатор пользователя
     */
    @JsonProperty(value = "uid")
    public long uid;

    /**
     * Идентификатор пользователя, снявшего заявку
     */
    @JsonProperty(value = "canceled_uid")
    public long canceledUid;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty(value = "exchange_code")
    public String exchangeCode;

    /**
     * Время активации
     */
    @JsonProperty(value = "activation_time")
    public Date activation_time;

    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty(value = "linkedorder")
    public long linkedOrder;

    /**
     * Дата окончания срока действия заявки
     */
    @JsonProperty(value = "expiry")
    public long expiry;

    /**
     * Код бумаги заявки
     */
    @JsonProperty(value = "sec_code")
    public String secCode;

    /**
     * Код класса заявки
     */
    @JsonProperty(value = "class_code")
    public String classCode;

    /**
     * Дата и время
     */
    @JsonProperty(value = "datetime")
    public Date tradeDateTime;

    /**
     * Дата и время снятия заявки
     */
    @JsonProperty(value = "withdraw_datetime")
    public Date withdrawDateTime;

    /**
     * Идентификатор расчетного счета/кода в клиринговой организации
     */
    @JsonProperty(value = "bank_acc_id")
    public String bankAccountId;

    /**
     * Способ указания объема заявки. Возможные значения:
     * «0» – по количеству,
     * «1» – по объему
     */
    @JsonProperty(value = "value_entry_type")
    public byte valueEntryType;

    /**
     * Срок РЕПО, в календарных днях
     */
    @JsonProperty(value = "repoterm")
    public int repoTerm;

    /**
     * Сумма РЕПО на текущую дату. Отображается с точностью 2 знака
     */
    @JsonProperty(value = "repovalue")
    public double repoValue;

    /**
     * Объём сделки выкупа РЕПО. Отображается с точностью 2 знака
     */
    @JsonProperty(value = "repo2value")
    public double repo2Value;

    /**
     * Остаток суммы РЕПО за вычетом суммы привлеченных
     * или предоставленных по сделке РЕПО денежных средств в неисполненной части заявки,
     * по состоянию на текущую дату.
     * Отображается с точностью 2 знака
     */
    @JsonProperty(value = "repo_value_balance")
    public double repoValueBalance;

    /**
     * Начальный дисконт, в %
     */
    @JsonProperty(value = "start_discount")
    public double startDiscount;

    /**
     * Причина отклонения заявки брокером
     */
    @JsonProperty(value = "reject_reason")
    public String rejectRreason;

    /**
     * Битовое поле для получения специфических параметров с западных площадок
     */
    @JsonProperty(value = "ext_order_flags")
    public int extOrderFlags;

    /**
     * Минимально допустимое количество, которое можно указать в заявке по данному инструменту.
     * Если имеет значение «0», значит ограничение по количеству не задано
     */
    @JsonProperty(value = "min_qty")
    public double minQuantity;

    /**
     * Тип исполнения заявки. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty(value = "exec_type")
    public int execType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty(value = "side_qualifier")
    public int sideQualifier;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty(value = "acnt_type")
    public int accountType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty(value = "capacity")
    public double capacity;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty(value = "passive_only_order")
    public byte passiveOnlyOrder;

    /**
     * Видимое количество. Параметр айсберг-заявок, для обычных заявок выводится значение: «0»
     */
    @JsonProperty(value = "visible")
    public double visible;
}
