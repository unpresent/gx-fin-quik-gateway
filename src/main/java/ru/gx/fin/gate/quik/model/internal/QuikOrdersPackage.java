package ru.gx.fin.gate.quik.model.internal;

import ru.gx.fin.gate.quik.model.original.OriginalQuikOrdersPackage;
import ru.gx.fin.gate.quik.model.original.OriginalQuikStandardDataObject;

@SuppressWarnings("unused")
public class QuikOrdersPackage extends QuikStandardDataPackage<QuikOrder> {
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
