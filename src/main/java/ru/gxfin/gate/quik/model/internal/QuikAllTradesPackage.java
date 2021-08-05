package ru.gxfin.gate.quik.model.internal;

import ru.gxfin.gate.quik.model.original.OriginalQuikAllTradesPackage;
import ru.gxfin.gate.quik.model.original.OriginalQuikStandardDataObject;

public class QuikAllTradesPackage extends QuikStandardDataPackage<QuikAllTrade> {
    @SuppressWarnings("unused")
    public QuikAllTradesPackage() {
        super();
    }

    public QuikAllTradesPackage(OriginalQuikAllTradesPackage originalPackage) {
        super(originalPackage);
    }

    @Override
    public QuikAllTrade createInstanceFromQuikSource(OriginalQuikStandardDataObject quikDataObject) {
        return new QuikAllTrade(quikDataObject);
    }
}

