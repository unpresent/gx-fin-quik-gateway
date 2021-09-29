package ru.gx.fin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import ru.gx.fin.gate.quik.model.memdata.QuikOrdersMemoryRepository;
import ru.gx.utils.BigDecimalUtils;
import ru.gx.utils.StringUtils;
import ru.gx.fin.gate.quik.model.original.OriginalQuikOrder;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Заявка
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class, resolver = QuikOrdersMemoryRepository.IdResolver.class)
// TODO: Подумать над Key!
public class QuikOrder extends QuikStandardDataObject {

    /**
     * Идентификатор сделки - составной ключ = {@link #exchangeCode} + ":" + {@link #orderNum}.
     */
    @NotNull
    private String id;

    /**
     * Вычисление идентификатора сделки.
     */
    protected void calcId() {
        this.id = this.exchangeCode + ":" + this.orderNum;
    }

    /**
     * Номер заявки в торговой системе
     */
    private String orderNum;

    /**
     * Направление поручения
     */
    private QuikDealDirection direction;

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
     * Остаток
     */
    private BigDecimal balance;

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
     * Идентификатор транзакции
     */
    private long transactionId;

    /**
     * Код клиента
     */
    private String clientCode;

    /**
     * Цена выкупа
     */
    private BigDecimal price2;

    /**
     * Код расчетов
     */
    private String settleCode;

    /**
     * Идентификатор пользователя
     */
    private long uid;

    /**
     * Идентификатор пользователя, снявшего заявку
     */
    private long canceledUid;

    /**
     * Код биржи в торговой системе
     */
    private String exchangeCode;

    /**
     * Время активации
     */
    private long activationTime;

    /**
     * Номер заявки в торговой системе
     */
    private long linkedOrder;

    /**
     * Дата окончания срока действия заявки
     */
    private long expiry;

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
    private LocalDateTime tradeDateTime;

    /**
     * Дата и время снятия заявки
     */
    private LocalDateTime withdrawDateTime;

    /**
     * Идентификатор расчетного счета/кода в клиринговой организации.
     */
    private String bankAccountId;

    /**
     * Способ указания объема заявки. Возможные значения:
     * «0» – по количеству,
     * «1» – по объему
     */
    private byte valueEntryType;

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
     * Остаток суммы РЕПО за вычетом суммы привлеченных
     * или предоставленных по сделке РЕПО денежных средств в неисполненной части заявки,
     * по состоянию на текущую дату.
     * Отображается с точностью 2 знака
     */
    private BigDecimal repoValueBalance;

    /**
     * Начальный дисконт, в %
     */
    private BigDecimal startDiscount;

    /**
     * Причина отклонения заявки брокером
     */
    private String rejectReason;

    /**
     * Битовое поле для получения специфических параметров с западных площадок
     */
    private int extOrderFlags;

    /**
     * Минимально допустимое количество, которое можно указать в заявке по данному инструменту.
     * Если имеет значение «0», значит ограничение по количеству не задано
     */
    private BigDecimal minQuantity;

    /**
     * Тип исполнения заявки. Если имеет значение «0», значит значение не задано
     */
    private int execType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    private int sideQualifier;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    private int accountType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    private BigDecimal capacity;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    private byte passiveOnlyOrder;

    /**
     * Видимое количество. Параметр айсберг-заявок, для обычных заявок выводится значение: «0»
     */
    private BigDecimal visible;

    @SuppressWarnings("unused")
    public QuikOrder() {
        super();
    }

    public QuikOrder(OriginalQuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        final var sourceDataObject = (OriginalQuikOrder) quikDataObject;
        // Определяем код площадки
        this.classCode = StringUtils.nullIf(sourceDataObject.getClassCode(), "");
        this.exchangeCode = extractExchangeCode(sourceDataObject.getExchangeCode(), this.classCode);
        // Номер поручения
        this.orderNum = sourceDataObject.getOrderNum();
        // Определяем идентификатор - составной
        calcId();
        // Остальные поля
        this.direction = sourceDataObject.getFlags() == 0 ? QuikDealDirection.S : QuikDealDirection.B;
        this.brokerRef = StringUtils.nullIf(sourceDataObject.getBrokerRef(), "");
        this.userId = StringUtils.nullIf(sourceDataObject.getUserId(), "");
        this.firmId = StringUtils.nullIf(sourceDataObject.getFirmId(), "");
        this.account = StringUtils.nullIf(sourceDataObject.getAccount(), "");
        this.price = sourceDataObject.getPrice();
        this.quantity = sourceDataObject.getQuantity();
        this.balance = BigDecimalUtils.nullIf(sourceDataObject.getBalance(), BigDecimal.ZERO);
        this.value = sourceDataObject.getValue();
        this.accruedInterest = BigDecimalUtils.nullIf(sourceDataObject.getAccruedInterest(), BigDecimal.ZERO);
        this.yield = BigDecimalUtils.nullIf(sourceDataObject.getYield(), BigDecimal.ZERO);
        this.transactionId = sourceDataObject.getTransactionId();
        this.clientCode = StringUtils.nullIf(sourceDataObject.getClientCode(), "");
        this.price2 = BigDecimalUtils.nullIf(sourceDataObject.getPrice2(), BigDecimal.ZERO);
        this.settleCode = sourceDataObject.getSettleCode();
        this.uid = sourceDataObject.getUid();
        this.canceledUid = sourceDataObject.getCanceledUid();
        this.activationTime = sourceDataObject.getActivationTime();
        this.linkedOrder = sourceDataObject.getLinkedOrder();
        this.expiry = sourceDataObject.getExpiry();
        this.secCode = sourceDataObject.getSecCode();
        this.tradeDateTime = sourceDataObject.getTradeDateTime();
        this.withdrawDateTime = sourceDataObject.getWithdrawDateTime();
        this.bankAccountId = StringUtils.nullIf(sourceDataObject.getBankAccountId(), "");
        this.valueEntryType = sourceDataObject.getValueEntryType();
        this.repoTerm = sourceDataObject.getRepoTerm();
        this.repoValue = BigDecimalUtils.nullIf(sourceDataObject.getRepoValue(), BigDecimal.ZERO);
        this.repo2Value = BigDecimalUtils.nullIf(sourceDataObject.getRepo2Value(), BigDecimal.ZERO);
        this.repoValueBalance = BigDecimalUtils.nullIf(sourceDataObject.getRepoValueBalance(), BigDecimal.ZERO);
        this.startDiscount = BigDecimalUtils.nullIf(sourceDataObject.getStartDiscount(), BigDecimal.ZERO);
        this.rejectReason = StringUtils.nullIf(sourceDataObject.getRejectReason(), "");
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
