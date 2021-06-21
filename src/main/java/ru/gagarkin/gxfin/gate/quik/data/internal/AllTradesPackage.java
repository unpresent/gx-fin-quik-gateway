package ru.gagarkin.gxfin.gate.quik.data.internal;

import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataObject;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataPackage;

public class AllTradesPackage extends StandardDataPackage<AllTrade> {
    public AllTradesPackage() {
        super();
    }

    public AllTradesPackage(QuikStandardDataPackage quikDataPackage) {
        super(quikDataPackage);
    }

    /*
    @Override
    public Class rowsClass() {
        return AllTrade.class;
    }
    /*/

    @Override
    public AllTrade createInstanceFromQuikSource(QuikStandardDataObject quikDataObject) {
        return new AllTrade(quikDataObject);
    }
}

