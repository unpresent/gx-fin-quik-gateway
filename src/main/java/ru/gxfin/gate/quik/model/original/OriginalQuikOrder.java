package ru.gxfin.gate.quik.model.original;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Заявка
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class OriginalQuikOrder extends OriginalQuikStandardDataObject {
    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty(value = "order_num")
    private String orderNum;

    /**
     * Набор битовых флагов
     */
    @JsonProperty(value = "flags")
    private int flags;

    /**
     * Комментарий, обычно: <код клиента>/<номер поручения>
     */
    @JsonProperty(value = "brokerref")
    private String brokerRef;

    /**
     * Идентификатор трейдера
     */
    @JsonProperty(value = "userid")
    private String userId;

    /**
     * Идентификатор фирмы
     */
    @JsonProperty(value = "firmid")
    private String firmId;

    /**
     * Торговый счет
     */
    @JsonProperty(value = "account")
    private String account;

    /**
     * Цена
     */
    @JsonProperty(value = "price")
    private BigDecimal price;

    /**
     * Количество в лотах
     */
    @JsonProperty(value = "qty")
    private BigDecimal quantity;

    /**
     * Остаток
     */
    @JsonProperty(value = "balance")
    private BigDecimal balance;

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
     * Идентификатор транзакции
     */
    @JsonProperty(value = "trans_id")
    private long transactionId;

    /**
     * Код клиента
     */
    @JsonProperty(value = "client_code")
    private String clientCode;

    /**
     * Цена выкупа
     */
    @JsonProperty(value = "price2")
    private BigDecimal price2;

    /**
     * Код расчетов
     */
    @JsonProperty(value = "settlecode")
    private String settleCode;

    /**
     * Идентификатор пользователя
     */
    @JsonProperty(value = "uid")
    private long uid;

    /**
     * Идентификатор пользователя, снявшего заявку
     */
    @JsonProperty(value = "canceled_uid")
    private long canceledUid;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty(value = "exchange_code")
    private String exchangeCode;

    /**
     * Время активации
     */
    @JsonProperty(value = "activation_time")
    private LocalDateTime activationTime;

    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty(value = "linkedorder")
    private long linkedOrder;

    /**
     * Дата окончания срока действия заявки
     */
    @JsonProperty(value = "expiry")
    private long expiry;

    /**
     * Код бумаги заявки
     */
    @JsonProperty(value = "sec_code")
    private String secCode;

    /**
     * Код класса заявки
     */
    @JsonProperty(value = "class_code")
    private String classCode;

    /**
     * Дата и время
     */
    @JsonProperty(value = "datetime")
    private LocalDateTime tradeDateTime;

    /**
     * Дата и время снятия заявки
     */
    @JsonProperty(value = "withdraw_datetime")
    private LocalDateTime withdrawDateTime;

    /**
     * Идентификатор расчетного счета/кода в клиринговой организации
     */
    @JsonProperty(value = "bank_acc_id")
    private String bankAccountId;

    /**
     * Способ указания объема заявки. Возможные значения:
     * «0» – по количеству,
     * «1» – по объему
     */
    @JsonProperty(value = "value_entry_type")
    private byte valueEntryType;

    /**
     * Срок РЕПО, в календарных днях
     */
    @JsonProperty(value = "repoterm")
    private int repoTerm;

    /**
     * Сумма РЕПО на текущую дату. Отображается с точностью 2 знака
     */
    @JsonProperty(value = "repovalue")
    private BigDecimal repoValue;

    /**
     * Объём сделки выкупа РЕПО. Отображается с точностью 2 знака
     */
    @JsonProperty(value = "repo2value")
    private BigDecimal repo2Value;

    /**
     * Остаток суммы РЕПО за вычетом суммы привлеченных
     * или предоставленных по сделке РЕПО денежных средств в неисполненной части заявки,
     * по состоянию на текущую дату.
     * Отображается с точностью 2 знака
     */
    @JsonProperty(value = "repo_value_balance")
    private BigDecimal repoValueBalance;

    /**
     * Начальный дисконт, в %
     */
    @JsonProperty(value = "start_discount")
    private BigDecimal startDiscount;

    /**
     * Причина отклонения заявки брокером
     */
    @JsonProperty(value = "reject_reason")
    private String rejectReason;

    /**
     * Битовое поле для получения специфических параметров с западных площадок
     */
    @JsonProperty(value = "ext_order_flags")
    private int extOrderFlags;

    /**
     * Минимально допустимое количество, которое можно указать в заявке по данному инструменту.
     * Если имеет значение «0», значит ограничение по количеству не задано
     */
    @JsonProperty(value = "min_qty")
    private BigDecimal minQuantity;

    /**
     * Тип исполнения заявки. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty(value = "exec_type")
    private int execType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty(value = "side_qualifier")
    private int sideQualifier;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty(value = "acnt_type")
    private int accountType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty(value = "capacity")
    private BigDecimal capacity;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    @JsonProperty(value = "passive_only_order")
    private byte passiveOnlyOrder;

    /**
     * Видимое количество. Параметр айсберг-заявок, для обычных заявок выводится значение: «0»
     */
    @JsonProperty(value = "visible")
    private BigDecimal visible;
}
