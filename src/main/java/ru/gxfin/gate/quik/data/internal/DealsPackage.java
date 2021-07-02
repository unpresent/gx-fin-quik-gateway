package ru.gxfin.gate.quik.data.internal;

import ru.gxfin.gate.quik.data.income.QuikStandardDataObject;
import ru.gxfin.gate.quik.data.income.QuikStandardDataPackage;

public class DealsPackage extends StandardDataPackage<Deal> {
    public DealsPackage() {
        super();
    }

    public DealsPackage(QuikStandardDataPackage quikDataPackage) {
        super(quikDataPackage);
    }

    /*
    @Override
    public Class rowsClass() {
        return Deal.class;
    }
    /*/

    @Override
    public Deal createInstanceFromQuikSource(QuikStandardDataObject quikDataObject) {
        return new Deal(quikDataObject);
    }
}
