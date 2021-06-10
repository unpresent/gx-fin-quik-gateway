package ru.gagarkin.gxfin.gate.quik.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Сделка
 */
public class Deal extends StandardDtoObject {
    /**
     * Номер сделки в торговой системе
     */
    @JsonProperty(value = "trade_num")
    public String tradeNum;

    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty(value = "order_num")
    public String orderNum;

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
     * Идентификатор пользователя, снявшего заявку
     */
    @JsonProperty(value = "canceled_uid")
    public long canceledUid;

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
     * Код фирмы партнера
     */
    @JsonProperty(value = "cpfirmid")
    public String cpFirmId;

    /**
     * Набор битовых флагов
     */
    @JsonProperty(value = "flags")
    public int flags;

    /**
     * Цена выкупа
     */
    @JsonProperty(value = "price2")
    public double price2;

    /**
     * Ставка РЕПО (%)
     */
    @JsonProperty(value = "reporate")
    public double repoRate;

    /**
     * Код клиента
     */
    @JsonProperty(value = "client_code")
    public String clientCode;

    /**
     * Доход (%) на дату выкупа
     */
    @JsonProperty(value = "accrued2")
    public double accrued2;

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
     * Начальный дисконт (%)
     */
    @JsonProperty(value = "start_discount")
    public double startDiscount;

    /**
     * Нижний дисконт (%)
     */
    @JsonProperty(value = "lower_discount")
    public double lowerDiscount;

    /**
     * Верхний дисконт (%)
     */
    @JsonProperty(value = "upper_discount")
    public double upperDiscount;

    /**
     * Блокировка обеспечения («Да»/«Нет»)
     */
    @JsonProperty(value = "block_securities")
    public double blockSecurities;

    /**
     * Клиринговая комиссия (ММВБ)
     */
    @JsonProperty(value = "clearing_comission")
    public double clearingComission;

    /**
     * Комиссия Фондовой биржи (ММВБ)
     */
    @JsonProperty(value = "exchange_comission")
    public double exchangeComission;

    /**
     * Комиссия Технического центра (ММВБ)
     */
    @JsonProperty(value = "tech_center_comission")
    public double techCenterComission;

    /**
     * Дата расчетов
     */
    @JsonProperty(value = "settle_date")
    public int settleDate;

    /**
     * Валюта расчетов
     */
    @JsonProperty(value = "settle_currency")
    public String settleCurrency;

    /**
     * Валюта
     */
    @JsonProperty(value = "trade_currency")
    public String tradeCurrency;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty(value = "exchange_code")
    public String exchangeCode;

    /**
     * Идентификатор рабочей станции
     */
    @JsonProperty(value = "station_id")
    public long stationId;

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
     * Идентификатор расчетного счета/кода в клиринговой организации
     */
    @JsonProperty(value = "bank_acc_id")
    public String bankAccountId;

    /**
     * Комиссия брокера. Отображается с точностью до 2 двух знаков. Поле зарезервировано для будущего использования
     */
    @JsonProperty(value = "broker_comission")
    public double brokerComission;

    /**
     * Номер витринной сделки в Торговой Системе для сделок РЕПО с ЦК и SWAP
     */
    @JsonProperty(value = "linked_trade")
    public long linkedTrade;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    @JsonProperty(value = "period")
    public short period;

    /**
     * Идентификатор транзакции
     */
    @JsonProperty(value = "trans_id")
    public long transactionId;

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
    public short kind;

    /**
     * Идентификатор счета в НКЦ (расчетный код)
     */
    @JsonProperty(value = "clearing_bank_accid")
    public String clearingBankAccountId;

    /**
     * Дата и время снятия сделки
     */
    @JsonProperty(value = "canceled_datetime")
    public Date canceledDateTime;

    /**
     * Идентификатор фирмы - участника клиринга
     */
    @JsonProperty(value = "clearing_firmid")
    public String clearingFirmId;

    /**
     * Дополнительная информация по сделке, передаваемая торговой системой
     */
    @JsonProperty(value = "system_ref")
    public String systemRef;

    /**
     * Идентификатор пользователя
     */
    @JsonProperty(value = "uid")
    public long uid;
}
