package ru.gxfin.gate.quik.data.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.gxfin.gate.quik.data.income.QuikDeal;
import ru.gxfin.gate.quik.data.income.QuikStandardDataObject;

import java.util.Date;

/**
 * Сделка
 */
@Getter
@Setter
@EqualsAndHashCode
public class Deal extends StandardDataObject {
    /**
     * Номер сделки в торговой системе
     */
    @JsonProperty
    private String tradeNum;

    /**
     * Номер заявки в торговой системе
     */
    @JsonProperty
    private String orderNum;

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
     * Идентификатор пользователя, снявшего заявку
     */
    @JsonProperty
    private long canceledUid;

    /**
     * Торговый счет
     */
    @JsonProperty
    private String account;

    /**
     * Цена
     */
    @JsonProperty
    private double price;

    /**
     * Количество в лотах
     */
    @JsonProperty
    private double quantity;

    /**
     * Объем в денежных средствах
     */
    @JsonProperty
    private double value;

    /**
     * Накопленный купонный доход
     */
    @JsonProperty
    private double accruedInterest;

    /**
     * Доходность
     */
    @JsonProperty
    private double yield;

    /**
     * Код расчетов
     */
    @JsonProperty
    private String settleCode;

    /**
     * Код фирмы партнера
     */
    @JsonProperty
    private String cpFirmId;

    /**
     * Набор битовых флагов
     */
    @JsonProperty
    private int flags;

    /**
     * Цена выкупа
     */
    @JsonProperty
    private double price2;

    /**
     * Ставка РЕПО (%)
     */
    @JsonProperty
    private double repoRate;

    /**
     * Код клиента
     */
    @JsonProperty
    private String clientCode;

    /**
     * Доход (%) на дату выкупа
     */
    @JsonProperty
    private double accrued2;

    /**
     * Срок РЕПО, в календарных днях
     */
    @JsonProperty
    private int repoTerm;

    /**
     * Сумма РЕПО на текущую дату. Отображается с точностью 2 знака
     */
    @JsonProperty
    private double repoValue;

    /**
     * Объём сделки выкупа РЕПО. Отображается с точностью 2 знака
     */
    @JsonProperty
    private double repo2Value;

    /**
     * Начальный дисконт (%)
     */
    @JsonProperty
    private double startDiscount;

    /**
     * Нижний дисконт (%)
     */
    @JsonProperty
    private double lowerDiscount;

    /**
     * Верхний дисконт (%)
     */
    @JsonProperty
    private double upperDiscount;

    /**
     * Блокировка обеспечения («Да»/«Нет»)
     */
    @JsonProperty
    private double blockSecurities;

    /**
     * Клиринговая комиссия (ММВБ)
     */
    @JsonProperty
    private double clearingComission;

    /**
     * Комиссия Фондовой биржи (ММВБ)
     */
    @JsonProperty
    private double exchangeComission;

    /**
     * Комиссия Технического центра (ММВБ)
     */
    @JsonProperty
    private double techCenterComission;

    /**
     * Дата расчетов
     */
    @JsonProperty
    private int settleDate;

    /**
     * Валюта расчетов
     */
    @JsonProperty
    private String settleCurrency;

    /**
     * Валюта
     */
    @JsonProperty
    private String tradeCurrency;

    /**
     * Код биржи в торговой системе
     */
    @JsonProperty
    private String exchangeCode;

    /**
     * Идентификатор рабочей станции
     */
    @JsonProperty
    private long stationId;

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
     * Идентификатор расчетного счета/кода в клиринговой организации
     */
    @JsonProperty
    private String bankAccountId;

    /**
     * Комиссия брокера. Отображается с точностью до 2 двух знаков. Поле зарезервировано для будущего использования
     */
    @JsonProperty
    private double brokerComission;

    /**
     * Номер витринной сделки в Торговой Системе для сделок РЕПО с ЦК и SWAP
     */
    @JsonProperty
    private long linkedTrade;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    @JsonProperty
    private short period;

    /**
     * Идентификатор транзакции
     */
    @JsonProperty
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
    @JsonProperty
    private short kind;

    /**
     * Идентификатор счета в НКЦ (расчетный код)
     */
    @JsonProperty
    private String clearingBankAccountId;

    /**
     * Дата и время снятия сделки
     */
    @JsonProperty
    private Date canceledDateTime;

    /**
     * Идентификатор фирмы - участника клиринга
     */
    @JsonProperty
    private String clearingFirmId;

    /**
     * Дополнительная информация по сделке, передаваемая торговой системой
     */
    @JsonProperty
    private String systemRef;

    /**
     * Идентификатор пользователя
     */
    @JsonProperty
    private long uid;

    public Deal() {
        super();
    }

    public Deal(QuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        final var sourceDataObject = (QuikDeal) quikDataObject;
        this.tradeNum = sourceDataObject.getTradeNum();
        this.orderNum = sourceDataObject.getOrderNum();
        this.brokerRef = sourceDataObject.getBrokerRef();
        this.userId = sourceDataObject.getUserId();
        this.firmId = sourceDataObject.getFirmId();
        this.canceledUid = sourceDataObject.getCanceledUid();
        this.account = sourceDataObject.getAccount();
        this.price = sourceDataObject.getPrice();
        this.quantity = sourceDataObject.getQuantity();
        this.value = sourceDataObject.getValue();
        this.accruedInterest = sourceDataObject.getAccruedInterest();
        this.yield = sourceDataObject.getYield();
        this.settleCode = sourceDataObject.getSettleCode();
        this.cpFirmId = sourceDataObject.getCpFirmId();
        this.flags = sourceDataObject.getFlags();
        this.price2 = sourceDataObject.getPrice2();
        this.repoRate = sourceDataObject.getRepoRate();
        this.clientCode = sourceDataObject.getClientCode();
        this.accrued2 = sourceDataObject.getAccrued2();
        this.repoTerm = sourceDataObject.getRepoTerm();
        this.repoValue = sourceDataObject.getRepoValue();
        this.repo2Value = sourceDataObject.getRepo2Value();
        this.startDiscount = sourceDataObject.getStartDiscount();
        this.lowerDiscount = sourceDataObject.getLowerDiscount();
        this.upperDiscount = sourceDataObject.getUpperDiscount();
        this.blockSecurities = sourceDataObject.getBlockSecurities();
        this.clearingComission = sourceDataObject.getClearingComission();
        this.exchangeComission = sourceDataObject.getExchangeComission();
        this.techCenterComission = sourceDataObject.getTechCenterComission();
        this.settleDate = sourceDataObject.getSettleDate();
        this.settleCurrency = sourceDataObject.getSettleCurrency();
        this.tradeCurrency = sourceDataObject.getTradeCurrency();
        this.exchangeCode = sourceDataObject.getExchangeCode();
        this.stationId = sourceDataObject.getStationId();
        this.secCode = sourceDataObject.getSecCode();
        this.classCode = sourceDataObject.getClassCode();
        this.tradeDateTime = sourceDataObject.getTradeDateTime();
        this.bankAccountId = sourceDataObject.getBankAccountId();
        this.brokerComission = sourceDataObject.getBrokerComission();
        this.linkedTrade = sourceDataObject.getLinkedTrade();
        this.period = sourceDataObject.getPeriod();
        this.transactionId = sourceDataObject.getTransactionId();
        this.kind = sourceDataObject.getKind();
        this.clearingBankAccountId = sourceDataObject.getClearingBankAccountId();
        this.canceledDateTime = sourceDataObject.getCanceledDateTime();
        this.clearingFirmId = sourceDataObject.getClearingFirmId();
        this.systemRef = sourceDataObject.getSystemRef();
        this.uid = sourceDataObject.getUid();
    }
}
