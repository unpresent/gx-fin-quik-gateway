package ru.gagarkin.gxfin.gate.quik.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class StandardPackage<T extends StandardDtoObject> extends AbstractPackage {
    /**
     * Общее количество записей в Quik-е
     */
    @JsonProperty(value = "all_count")
    public long allCount;

    /**
     * Записи данного пакета
     */
    @JsonProperty(value = "rows")
    public T[] rows;

    /**
     * Тип объектов пакета
     */
    abstract public Class rowsClass();
}
