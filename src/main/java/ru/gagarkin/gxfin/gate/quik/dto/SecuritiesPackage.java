package ru.gagarkin.gxfin.gate.quik.dto;

public class SecuritiesPackage extends StandardPackage<Security> {
    @Override
    public Class rowsClass() {
        return Security.class;
    }
}
