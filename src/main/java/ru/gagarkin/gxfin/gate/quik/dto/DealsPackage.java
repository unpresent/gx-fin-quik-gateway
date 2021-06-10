package ru.gagarkin.gxfin.gate.quik.dto;

public class DealsPackage extends StandardPackage<Deal> {
    @Override
    public Class rowsClass() {
        return Deal.class;
    }
}
