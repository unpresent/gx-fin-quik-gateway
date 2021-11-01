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
 * Сделка
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class OriginalQuikDeal extends OriginalQuikStandardDataObject {
    /**
     * Номер сделки в торговой системе
     */
    @JsonProperty(value = "trade_num")
    private String tradeNum;

    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty(value = "order_num")
    private String orderNum;

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
     * Идентификатор пользователя, снявшего заявку
     */
    @JsonProperty(value = "canceled_uid")
    private long canceledUid;

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
     * Код фирмы партнера
     */
    @JsonProperty(value = "cpfirmid")
    private String cpFirmId;

    /**
     * Набор битовых флагов
     */
    @JsonProperty(value = "flags")
    private int flags;

    /**
     * Цена выкупа
     */
    @JsonProperty(value = "price2")
    private BigDecimal price2;

    /**
     * Ставка РЕПО (%)
     */
    @JsonProperty(value = "reporate")
    private BigDecimal repoRate;

    /**
     * Код клиента
     */
    @JsonProperty(value = "client_code")
    private String clientCode;

    /**
     * Доход (%) на дату выкупа
     */
    @JsonProperty(value = "accrued2")
    private BigDecimal accrued2;

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
     * Начальный дисконт (%)
     */
    @JsonProperty(value = "start_discount")
    private BigDecimal startDiscount;

    /**
     * Нижний дисконт (%)
     */
    @JsonProperty(value = "lower_discount")
    private BigDecimal lowerDiscount;

    /**
     * Верхний дисконт (%)
     */
    @JsonProperty(value = "upper_discount")
    private BigDecimal upperDiscount;

    /**
     * Блокировка обеспечения («Да»/«Нет»)
     */
    @JsonProperty(value = "block_securities")
    private BigDecimal blockSecurities;

    /**
     * Клиринговая комиссия (ММВБ)
     */
    @JsonProperty(value = "clearing_comission")
    private BigDecimal clearingComission;

    /**
     * Комиссия Фондовой биржи (ММВБ)
     */
    @JsonProperty(value = "exchange_comission")
    private BigDecimal exchangeComission;

    /**
     * Комиссия Технического центра (ММВБ)
     */
    @JsonProperty(value = "tech_center_comission")
    private BigDecimal techCenterComission;

    /**
     * Дата расчетов
     */
    @JsonProperty(value = "settle_date")
    private int settleDate;

    /**
     * Валюта расчетов
     */
    @JsonProperty(value = "settle_currency")
    private String settleCurrency;

    /**
     * Валюта
     */
    @JsonProperty(value = "trade_currency")
    private String tradeCurrency;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty(value = "exchange_code")
    private String exchangeCode;

    /**
     * Идентификатор рабочей станции
     */
    @JsonProperty(value = "station_id")
    private long stationId;

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
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime tradeDateTime;

    /**
     * Идентификатор расчетного счета/кода в клиринговой организации
     */
    @JsonProperty(value = "bank_acc_id")
    private String bankAccountId;

    /**
     * Комиссия брокера. Отображается с точностью до 2 двух знаков. Поле зарезервировано для будущего использования
     */
    @JsonProperty(value = "broker_comission")
    private BigDecimal brokerComission;

    /**
     * Номер витринной сделки в Торговой Системе для сделок РЕПО с ЦК и SWAP
     */
    @JsonProperty(value = "linked_trade")
    private long linkedTrade;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    @JsonProperty(value = "period")
    private short period;

    /**
     * Идентификатор транзакции
     */
    @JsonProperty(value = "trans_id")
    private long transactionId;

    /**
     * Тип сделки. Возможные значения:
     *
     * «1» – Обычная;
     * «2» – Адресная;
     * «3» – Первичное размещение;
     * «4» – Перевод денег/бумаг;
     * «5» – Адресная сделка первой части РЕПО;
     * «6» – Расчетная по операции своп;
     * «7» – Расчетная по внебиржевой операции своп;
     * «8» – Расчетная сделка бивалютной корзины;
     * «9» – Расчетная внебиржевая сделка бивалютной корзины;
     * «10» – Сделка по операции РЕПО с ЦК;
     * «11» – Первая часть сделки по операции РЕПО с ЦК;
     * «12» – Вторая часть сделки по операции РЕПО с ЦК;
     * «13» – Адресная сделка по операции РЕПО с ЦК;
     * «14» – Первая часть адресной сделки по операции РЕПО с ЦК;
     * «15» – Вторая часть адресной сделки по операции РЕПО с ЦК;
     * «16» – Техническая сделка по возврату активов РЕПО с ЦК;
     * «17» – Сделка по спреду между фьючерсами разных сроков на один актив;
     * «18» – Техническая сделка первой части от спреда между фьючерсами;
     * «19» – Техническая сделка второй части от спреда между фьючерсами;
     * «20» – Адресная сделка первой части РЕПО с корзиной;
     * «21» – Адресная сделка второй части РЕПО с корзиной;
     * «22» – Перенос позиций срочного рынка
     */
    @JsonProperty(value = "kind")
    private short kind;

    /**
     * Идентификатор счета в НКЦ (расчетный код)
     */
    @JsonProperty(value = "clearing_bank_accid")
    private String clearingBankAccountId;

    /**
     * Дата и время снятия сделки
     */
    @JsonProperty(value = "canceled_datetime")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime canceledDateTime;

    /**
     * Идентификатор фирмы - участника клиринга
     */
    @JsonProperty(value = "clearing_firmid")
    private String clearingFirmId;

    /**
     * Дополнительная информация по сделке, передаваемая торговой системой
     */
    @JsonProperty(value = "system_ref")
    private String systemRef;

    /**
     * Идентификатор пользователя
     */
    @JsonProperty(value = "uid")
    private long uid;
}
