package ru.gx.fin.gate.quik.model.internal;

import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;
import ru.gx.fin.gate.quik.model.original.OriginalQuikAllTradesPackage;

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

