package ru.gxfin.gate.quik.model.internal;

import com.fasterxml.jackson.annotation.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.gxfin.common.data.ObjectCreateException;
import ru.gxfin.gate.quik.model.memdata.QuikSecuritiesMemoryRepository;
import ru.gxfin.gate.quik.model.original.OriginalQuikSecurity;
import ru.gxfin.gate.quik.model.original.OriginalQuikStandardDataObject;

import java.math.BigDecimal;

/**
 * Инструмент
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class, resolver = QuikSecuritiesMemoryRepository.IdResolver.class)
public class QuikSecurity extends QuikStandardDataObject {
    private String id;

    /**
     * Вычисление идентификатора инструмента.
     */
    protected void calcId() {
        this.id = this.code + ":" + this.classCode;
    }

    /**
     * Код инструмента
     */
    private String code;

    /**
     * Наименование инструмента
     */
    private String name;

    /**
     * Короткое наименование инструмента
     */
    private String shortName;

    /**
     * Код класса инструментов
     */
    private String classCode;

    /**
     * Наименование класса инструментов
     */
    private String className;

    /**
     * Номинал
     */
    private BigDecimal faceValue;

    /**
     * Валюта номинала
     */
    private String faceUnit;

    /**
     * Точность (количество значащих цифр после запятой)
     */
    private int scale;

    /**
     * Дата погашения
     */
    private long maturityDate;

    /**
     * Размер лота
     */
    private BigDecimal lotSize;

    /**
     * ISIN
     */
    private String isinCode;

    /**
     * Минимальный шаг цены
     */
    private BigDecimal minPriceStep;

    public QuikSecurity() {
        super();
    }

    public QuikSecurity(OriginalQuikStandardDataObject quikDataObject) {
        super(quikDataObject);
        final var sourceDataObject = (OriginalQuikSecurity) quikDataObject;
        this.code = sourceDataObject.getCode();
        this.classCode = sourceDataObject.getClassCode();
        // Определяем идентификатор - составной
        calcId();
        this.name = sourceDataObject.getName();
        this.shortName = sourceDataObject.getShortName();
        this.className = sourceDataObject.getClassName();
        this.faceValue = sourceDataObject.getFaceValue();
        this.faceUnit = sourceDataObject.getFaceUnit();
        this.scale = sourceDataObject.getScale();
        this.maturityDate = sourceDataObject.getMaturityDate();
        this.lotSize = sourceDataObject.getLotSize();
        this.isinCode = sourceDataObject.getIsinCode();
        this.minPriceStep = sourceDataObject.getMinPriceStep();
    }

    @SuppressWarnings("unused")
    @JsonCreator
    public static QuikSecurity createObject(
            @JsonProperty(value = "id") String id
    ) throws ObjectCreateException {
        return QuikSecuritiesMemoryRepository.ObjectsFactory.getOrCreateObject(id);
    }
}
