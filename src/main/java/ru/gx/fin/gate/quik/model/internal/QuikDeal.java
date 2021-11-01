package ru.gx.fin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import ru.gx.utils.BigDecimalUtils;
import ru.gx.utils.StringUtils;
import ru.gx.fin.gate.quik.model.memdata.QuikDealsMemoryRepository;
import ru.gx.fin.gate.quik.model.original.OriginalQuikDeal;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;

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
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(property = "rowIndex", generator = ObjectIdGenerators.PropertyGenerator.class, resolver = QuikDealsMemoryRepository.IdResolver.class)
public class QuikDeal extends QuikStandardDataObject {

    /**
     * Идентификатор сделки - составной ключ = {@link #exchangeCode} + ":" + {@link #tradeNum}.
     */
    @NotNull
    private String id;

    /**
     * Вычисление идентификатора сделки.
     */
    protected void calcId() {
        this.id = this.exchangeCode + ":" + this.tradeNum;
    }

    /**
     * Номер сделки в торговой системе
     */
    private String tradeNum;

    /**
     * Номер заявки в торговой системе
     */
    private String orderNum;

    /**
     * Комментарий, обычно: <код клиента>/<номер поручения>
     */
    private String brokerRef;

    /**
     * Идентификатор трейдера
     */
    private String userId;

    /**
     * Идентификатор фирмы
     */
    private String firmId;

    /**
     * Идентификатор пользователя, снявшего заявку
     */
    private long canceledUid;

    /**
     * Торговый счет
     */
    private String account;

    /**
     * Цена
     */
    private BigDecimal price;

    /**
     * Количество в лотах
     */
    private BigDecimal quantity;

    /**
     * Объем в денежных средствах
     */
    private BigDecimal value;

    /**
     * Накопленный купонный доход
     */
    private BigDecimal accruedInterest;

    /**
     * Доходность
     */
    private BigDecimal yield;

    /**
     * Код расчетов
     */
    private String settleCode;

    /**
     * Код фирмы партнера
     */
    private String cpFirmId;

    /**
     * Направление сделки
     */
    private QuikDealDirection direction;

    /**
     * Цена выкупа
     */
    private BigDecimal price2;

    /**
     * Ставка РЕПО (%)
     */
    private BigDecimal repoRate;

    /**
     * Код клиента
     */
    private String clientCode;

    /**
     * Доход (%) на дату выкупа
     */
    private BigDecimal accrued2;

    /**
     * Срок РЕПО, в календарных днях
     */
    private int repoTerm;

    /**
     * Сумма РЕПО на текущую дату. Отображается с точностью 2 знака
     */
    private BigDecimal repoValue;

    /**
     * Объём сделки выкупа РЕПО. Отображается с точностью 2 знака
     */
    private BigDecimal repo2Value;

    /**
     * Начальный дисконт (%)
     */
    private BigDecimal startDiscount;

    /**
     * Нижний дисконт (%)
     */
    private BigDecimal lowerDiscount;

    /**
     * Верхний дисконт (%)
     */
    private BigDecimal upperDiscount;

    /**
     * Блокировка обеспечения («Да»/«Нет»)
     */
    private BigDecimal blockSecurities;

    /**
     * Клиринговая комиссия (ММВБ)
     */
    private BigDecimal clearingComission;

    /**
     * Комиссия Фондовой биржи (ММВБ)
     */
    private BigDecimal exchangeComission;

    /**
     * Комиссия Технического центра (ММВБ)
     */
    private BigDecimal techCenterComission;

    /**
     * Дата расчетов
     */
    private int settleDate;

    /**
     * Валюта расчетов
     */
    private String settleCurrency;

    /**
     * Валюта
     */
    private String tradeCurrency;

    /**
     * Код биржи в торговой системе
     */
    private String exchangeCode;

    /**
     * Идентификатор рабочей станции
     */
    private long stationId;

    /**
     * Код бумаги заявки
     */
    private String secCode;

    /**
     * Код класса заявки
     */
    private String classCode;

    /**
     * Дата и время
     */
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime tradeDateTime;

    /**
     * Идентификатор расчетного счета/кода в клиринговой организации
     */
    private String bankAccountId;

    /**
     * Комиссия брокера. Отображается с точностью до 2 двух знаков. Поле зарезервировано для будущего использования
     */
    private BigDecimal brokerComission;

    /**
     * Номер витринной сделки в Торговой Системе для сделок РЕПО с ЦК и SWAP
     */
    private long linkedTrade;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    private short period;

    /**
     * Идентификатор транзакции
     */
    private long transactionId;

    /**
     * Тип сделки. Возможные значения:
     * <p>
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
    private short kind;

    /**
     * Идентификатор счета в НКЦ (расчетный код)
     */
    private String clearingBankAccountId;

    /**
     * Дата и время снятия сделки
     */
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime canceledDateTime;

    /**
     * Идентификатор фирмы - участника клиринга
     */
    private String clearingFirmId;

    /**
     * Дополнительная информация по сделке, передаваемая торговой системой
     */
    private String systemRef;

    /**
     * Идентификатор пользователя
     */
    private long uid;

    public QuikDeal(@NotNull final OriginalQuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        final var sourceDataObject = (OriginalQuikDeal) quikDataObject;
        // Определяем код площадки
        this.classCode = StringUtils.nullIf(sourceDataObject.getClassCode(), "");
        this.exchangeCode = extractExchangeCode(sourceDataObject.getExchangeCode(), this.classCode);
        // Номер сделки
        this.tradeNum = sourceDataObject.getTradeNum();
        // Определяем идентификатор - составной
        calcId();
        // Остальные поля
        this.direction = sourceDataObject.getFlags() == 0 ? QuikDealDirection.S : QuikDealDirection.B;
        this.orderNum = sourceDataObject.getOrderNum();
        this.brokerRef = sourceDataObject.getBrokerRef();
        this.userId = sourceDataObject.getUserId();
        this.firmId = sourceDataObject.getFirmId();
        this.canceledUid = sourceDataObject.getCanceledUid();
        this.account = StringUtils.nullIf(sourceDataObject.getAccount(), "");
        this.price = sourceDataObject.getPrice();
        this.quantity = sourceDataObject.getQuantity();
        this.value = sourceDataObject.getValue();
        this.accruedInterest = BigDecimalUtils.nullIf(sourceDataObject.getAccruedInterest(), BigDecimal.ZERO);
        this.yield = BigDecimalUtils.nullIf(sourceDataObject.getYield(), BigDecimal.ZERO);
        this.settleCode = StringUtils.nullIf(sourceDataObject.getSettleCode(), "");
        this.cpFirmId = StringUtils.nullIf(sourceDataObject.getCpFirmId(), "");
        this.price2 = BigDecimalUtils.nullIf(sourceDataObject.getPrice2(), BigDecimal.ZERO);
        this.repoRate = BigDecimalUtils.nullIf(sourceDataObject.getRepoRate(), BigDecimal.ZERO);
        this.clientCode = StringUtils.nullIf(sourceDataObject.getClientCode(), "");
        this.accrued2 = BigDecimalUtils.nullIf(sourceDataObject.getAccrued2(), BigDecimal.ZERO);
        this.repoTerm = sourceDataObject.getRepoTerm();
        this.repoValue = BigDecimalUtils.nullIf(sourceDataObject.getRepoValue(), BigDecimal.ZERO);
        this.repo2Value = BigDecimalUtils.nullIf(sourceDataObject.getRepo2Value(), BigDecimal.ZERO);
        this.startDiscount = BigDecimalUtils.nullIf(sourceDataObject.getStartDiscount(), BigDecimal.ZERO);
        this.lowerDiscount = BigDecimalUtils.nullIf(sourceDataObject.getLowerDiscount(), BigDecimal.ZERO);
        this.upperDiscount = BigDecimalUtils.nullIf(sourceDataObject.getUpperDiscount(), BigDecimal.ZERO);
        this.blockSecurities = sourceDataObject.getBlockSecurities();
        this.clearingComission = BigDecimalUtils.nullIf(sourceDataObject.getClearingComission(), BigDecimal.ZERO);
        this.exchangeComission = BigDecimalUtils.nullIf(sourceDataObject.getExchangeComission(), BigDecimal.ZERO);
        this.techCenterComission = BigDecimalUtils.nullIf(sourceDataObject.getTechCenterComission(), BigDecimal.ZERO);
        this.settleDate = sourceDataObject.getSettleDate();
        this.settleCurrency = sourceDataObject.getSettleCurrency();
        this.tradeCurrency = sourceDataObject.getTradeCurrency();
        this.stationId = sourceDataObject.getStationId();
        this.secCode = sourceDataObject.getSecCode();
        this.tradeDateTime = sourceDataObject.getTradeDateTime();
        this.bankAccountId = sourceDataObject.getBankAccountId();
        this.brokerComission = sourceDataObject.getBrokerComission();
        this.linkedTrade = sourceDataObject.getLinkedTrade();
        this.period = sourceDataObject.getPeriod();
        this.transactionId = sourceDataObject.getTransactionId();
        this.kind = sourceDataObject.getKind();
        this.clearingBankAccountId = StringUtils.nullIf(sourceDataObject.getClearingBankAccountId(), "");
        this.canceledDateTime = sourceDataObject.getCanceledDateTime();
        this.clearingFirmId = StringUtils.nullIf(sourceDataObject.getClearingFirmId(), "");
        this.systemRef = StringUtils.nullIf(sourceDataObject.getSystemRef(), "");
        this.uid = sourceDataObject.getUid();
    }
}
