package ru.gxfin.gate.quik.model.internal;

import ru.gxfin.gate.quik.model.income.QuikStandardDataObject;
import ru.gxfin.gate.quik.model.income.QuikStandardDataPackage;

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
