package ru.gxfin.gate.quik.model.internal;

import ru.gxfin.gate.quik.model.original.OriginalQuikSecuritiesPackage;
import ru.gxfin.gate.quik.model.original.OriginalQuikStandardDataObject;

@SuppressWarnings("unused")
public class QuikSecuritiesPackage extends QuikStandardDataPackage<QuikSecurity> {
    public QuikSecuritiesPackage() {
        super();
    }

    public QuikSecuritiesPackage(OriginalQuikSecuritiesPackage originalPackage) {
        super(originalPackage);
    }
    @Override
    public QuikSecurity createInstanceFromQuikSource(OriginalQuikStandardDataObject quikDataObject) {
        return new QuikSecurity(quikDataObject);
    }
}
