package ru.gagarkin.gxfin.gate.quik.dto;

public class AllTradesPackage extends StandardPackage<AllTrade> {
    @Override
    public Class rowsClass() {
        return AllTrade.class;
    }
}

