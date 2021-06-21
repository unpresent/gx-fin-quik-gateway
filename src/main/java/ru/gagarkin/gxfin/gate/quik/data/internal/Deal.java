package ru.gagarkin.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikDeal;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataObject;

import java.util.Date;

/**
 * Сделка
 */
public class Deal extends StandardDataObject {
    /**
     * Номер сделки в торговой системе
     */
    @JsonProperty
    public String tradeNum;

    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty
    public String orderNum;

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
     * Идентификатор пользователя, снявшего заявку
     */
    @JsonProperty
    public long canceledUid;

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
     * Код фирмы партнера
     */
    @JsonProperty
    public String cpFirmId;

    /**
     * Набор битовых флагов
     */
    @JsonProperty
    public int flags;

    /**
     * Цена выкупа
     */
    @JsonProperty
    public double price2;

    /**
     * Ставка РЕПО (%)
     */
    @JsonProperty
    public double repoRate;

    /**
     * Код клиента
     */
    @JsonProperty
    public String clientCode;

    /**
     * Доход (%) на дату выкупа
     */
    @JsonProperty
    public double accrued2;

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
     * Начальный дисконт (%)
     */
    @JsonProperty
    public double startDiscount;

    /**
     * Нижний дисконт (%)
     */
    @JsonProperty
    public double lowerDiscount;

    /**
     * Верхний дисконт (%)
     */
    @JsonProperty
    public double upperDiscount;

    /**
     * Блокировка обеспечения («Да»/«Нет»)
     */
    @JsonProperty
    public double blockSecurities;

    /**
     * Клиринговая комиссия (ММВБ)
     */
    @JsonProperty
    public double clearingComission;

    /**
     * Комиссия Фондовой биржи (ММВБ)
     */
    @JsonProperty
    public double exchangeComission;

    /**
     * Комиссия Технического центра (ММВБ)
     */
    @JsonProperty
    public double techCenterComission;

    /**
     * Дата расчетов
     */
    @JsonProperty
    public int settleDate;

    /**
     * Валюта расчетов
     */
    @JsonProperty
    public String settleCurrency;

    /**
     * Валюта
     */
    @JsonProperty
    public String tradeCurrency;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty
    public String exchangeCode;

    /**
     * Идентификатор рабочей станции
     */
    @JsonProperty
    public long stationId;

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
     * Идентификатор расчетного счета/кода в клиринговой организации
     */
    @JsonProperty
    public String bankAccountId;

    /**
     * Комиссия брокера. Отображается с точностью до 2 двух знаков. Поле зарезервировано для будущего использования
     */
    @JsonProperty
    public double brokerComission;

    /**
     * Номер витринной сделки в Торговой Системе для сделок РЕПО с ЦК и SWAP
     */
    @JsonProperty
    public long linkedTrade;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    @JsonProperty
    public short period;

    /**
     * Идентификатор транзакции
     */
    @JsonProperty
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
    @JsonProperty
    public short kind;

    /**
     * Идентификатор счета в НКЦ (расчетный код)
     */
    @JsonProperty
    public String clearingBankAccountId;

    /**
     * Дата и время снятия сделки
     */
    @JsonProperty
    public Date canceledDateTime;

    /**
     * Идентификатор фирмы - участника клиринга
     */
    @JsonProperty
    public String clearingFirmId;

    /**
     * Дополнительная информация по сделке, передаваемая торговой системой
     */
    @JsonProperty
    public String systemRef;

    /**
     * Идентификатор пользователя
     */
    @JsonProperty
    public long uid;

    protected Deal() {
        super();
    }

    protected Deal(QuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        var sourceDataObject = (QuikDeal) quikDataObject;
        this.tradeNum = sourceDataObject.tradeNum;
        this.orderNum = sourceDataObject.orderNum;
        this.brokerRef = sourceDataObject.brokerRef;
        this.userId = sourceDataObject.userId;
        this.firmId = sourceDataObject.firmId;
        this.canceledUid = sourceDataObject.canceledUid;
        this.account = sourceDataObject.account;
        this.price = sourceDataObject.price;
        this.quantity = sourceDataObject.quantity;
        this.value = sourceDataObject.value;
        this.accruedInterest = sourceDataObject.accruedInterest;
        this.yield = sourceDataObject.yield;
        this.settleCode = sourceDataObject.settleCode;
        this.cpFirmId = sourceDataObject.cpFirmId;
        this.flags = sourceDataObject.flags;
        this.price2 = sourceDataObject.price2;
        this.repoRate = sourceDataObject.repoRate;
        this.clientCode = sourceDataObject.clientCode;
        this.accrued2 = sourceDataObject.accrued2;
        this.repoTerm = sourceDataObject.repoTerm;
        this.repoValue = sourceDataObject.repoValue;
        this.repo2Value = sourceDataObject.repo2Value;
        this.startDiscount = sourceDataObject.startDiscount;
        this.lowerDiscount = sourceDataObject.lowerDiscount;
        this.upperDiscount = sourceDataObject.upperDiscount;
        this.blockSecurities = sourceDataObject.blockSecurities;
        this.clearingComission = sourceDataObject.clearingComission;
        this.exchangeComission = sourceDataObject.exchangeComission;
        this.techCenterComission = sourceDataObject.techCenterComission;
        this.settleDate = sourceDataObject.settleDate;
        this.settleCurrency = sourceDataObject.settleCurrency;
        this.tradeCurrency = sourceDataObject.tradeCurrency;
        this.exchangeCode = sourceDataObject.exchangeCode;
        this.stationId = sourceDataObject.stationId;
        this.secCode = sourceDataObject.secCode;
        this.classCode = sourceDataObject.classCode;
        this.tradeDateTime = sourceDataObject.tradeDateTime;
        this.bankAccountId = sourceDataObject.bankAccountId;
        this.brokerComission = sourceDataObject.brokerComission;
        this.linkedTrade = sourceDataObject.linkedTrade;
        this.period = sourceDataObject.period;
        this.transactionId = sourceDataObject.transactionId;
        this.kind = sourceDataObject.kind;
        this.clearingBankAccountId = sourceDataObject.clearingBankAccountId;
        this.canceledDateTime = sourceDataObject.canceledDateTime;
        this.clearingFirmId = sourceDataObject.clearingFirmId;
        this.systemRef = sourceDataObject.systemRef;
        this.uid = sourceDataObject.uid;
    }
}
