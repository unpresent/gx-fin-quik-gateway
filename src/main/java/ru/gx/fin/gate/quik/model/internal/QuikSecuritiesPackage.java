package ru.gx.fin.gate.quik.model.internal;

import ru.gx.fin.gate.quik.model.original.OriginalQuikSecuritiesPackage;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;

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
