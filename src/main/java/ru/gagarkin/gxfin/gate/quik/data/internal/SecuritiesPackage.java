package ru.gagarkin.gxfin.gate.quik.data.internal;

import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataObject;
import ru.gagarkin.gxfin.gate.quik.data.income.QuikStandardDataPackage;

public class SecuritiesPackage extends StandardDataPackage<Security> {
    public SecuritiesPackage() {
        super();
    }

    public SecuritiesPackage(QuikStandardDataPackage quikDataPackage) {
        super(quikDataPackage);
    }

    /*
    @Override
    public Class rowsClass() {
        return Security.class;
    }
    /*/

    @Override
    public Security createInstanceFromQuikSource(QuikStandardDataObject quikDataObject) {
        return new Security(quikDataObject);
    }
}
