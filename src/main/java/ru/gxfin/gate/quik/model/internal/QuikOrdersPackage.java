package ru.gxfin.gate.quik.model.internal;

import ru.gxfin.gate.quik.model.original.OriginalQuikOrdersPackage;
import ru.gxfin.gate.quik.model.original.OriginalQuikStandardDataObject;

public class QuikOrdersPackage extends QuikStandardDataPackage<QuikOrder> {
    @SuppressWarnings("unused")
    public QuikOrdersPackage() {
        super();
    }

    public QuikOrdersPackage(OriginalQuikOrdersPackage originalPackage) {
        super(originalPackage);
    }
    @Override
    public QuikOrder createInstanceFromQuikSource(OriginalQuikStandardDataObject quikDataObject) {
        return new QuikOrder(quikDataObject);
    }
}
