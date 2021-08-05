package ru.gxfin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.gxfin.common.data.ObjectCreateException;
import ru.gxfin.common.utils.BigDecimalUtils;
import ru.gxfin.common.utils.StringUtils;
import ru.gxfin.gate.quik.model.memdata.QuikAllTradesMemoryRepository;
import ru.gxfin.gate.quik.model.original.OriginalQuikAllTrade;
import ru.gxfin.gate.quik.model.original.OriginalQuikStandardDataObject;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Обезличенная сделка
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class, resolver = QuikAllTradesMemoryRepository.IdResolver.class)
public class QuikAllTrade extends QuikStandardDataObject {
    /**
     * Идентификатор сделки - составной ключ = {@link #exchangeCode} + ":" + {@link #tradeNum}.
     */
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
     * Направление сделки (Покупка / Продажа)
     */
    private QuikDealDirection direction;

    /**
     * Дата и время
     */
    private LocalDateTime tradeDateTime;

    /**
     * Код биржи в торговой системе
     */
    private String exchangeCode;

    /**
     * Код класса
     */
    private String classCode;

    /**
     * Код бумаги заявки
     */
    private String secCode;

    /**
     * Цена
     */
    private BigDecimal price;

    /**
     * Количество бумаг в последней сделке в лотах
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
     * Ставка РЕПО (%)
     */
    private BigDecimal repoRate;

    /**
     * Сумма РЕПО
     */
    private BigDecimal repoValue;

    /**
     * Объем выкупа РЕПО
     */
    private BigDecimal repo2Value;

    /**
     * Срок РЕПО в днях
     */
    private int repoTerm;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    private short period;

    /**
     * Открытый интерес
     */
    private int openInterest;

    public QuikAllTrade() {
        super();
    }

    public QuikAllTrade(OriginalQuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        final var sourceDataObject = (OriginalQuikAllTrade) quikDataObject;
        // Определяем код площадки
        this.classCode = StringUtils.nullIf(sourceDataObject.getClassCode(), "");
        this.exchangeCode = extractExchangeCode(sourceDataObject.getExchangeCode(), this.classCode);
        // Номер сделки
        this.tradeNum = sourceDataObject.getTradeNum();
        // Определяем идентификатор - составной
        calcId();
        // Остальные поля
        this.direction = sourceDataObject.getFlags() == 0 ? QuikDealDirection.S : QuikDealDirection.B;
        this.tradeDateTime = sourceDataObject.getTradeDateTime();
        /*
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        //*/
        this.secCode = StringUtils.nullIf(sourceDataObject.getSecCode(), "");
        this.price = sourceDataObject.getPrice();
        this.quantity = sourceDataObject.getQuantity();
        this.value = sourceDataObject.getValue();
        this.accruedInterest = BigDecimalUtils.nullIf(sourceDataObject.getAccruedInterest(), BigDecimal.ZERO);
        this.yield = BigDecimalUtils.nullIf(sourceDataObject.getYield(), BigDecimal.ZERO);
        this.settleCode = StringUtils.nullIf(sourceDataObject.getSettleCode(), "");
        this.repoRate = BigDecimalUtils.nullIf(sourceDataObject.getRepoRate(), BigDecimal.ZERO);
        this.repoValue = BigDecimalUtils.nullIf(sourceDataObject.getRepoValue(), BigDecimal.ZERO);
        this.repo2Value = BigDecimalUtils.nullIf(sourceDataObject.getRepo2Value(), BigDecimal.ZERO);
        this.repoTerm = sourceDataObject.getRepoTerm();
        this.period = sourceDataObject.getPeriod();
        this.openInterest = sourceDataObject.getOpenInterest();
    }

    @SuppressWarnings("unused")
    @JsonCreator
    public static QuikAllTrade createObject(
            @JsonProperty(value = "id") String id
    ) throws ObjectCreateException {
        return QuikAllTradesMemoryRepository.ObjectsFactory.getOrCreateObject(id);
    }
}
