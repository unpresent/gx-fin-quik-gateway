package ru.gxfin.gate.quik.model.internal;

import ru.gxfin.gate.quik.model.income.QuikStandardDataObject;
import ru.gxfin.gate.quik.model.income.QuikStandardDataPackage;

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

