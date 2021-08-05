package ru.gxfin.gate.quik.model.internal;

import ru.gxfin.gate.quik.model.original.OriginalQuikDealsPackage;
import ru.gxfin.gate.quik.model.original.OriginalQuikStandardDataObject;

public class QuikDealsPackage extends QuikStandardDataPackage<QuikDeal> {
    @SuppressWarnings("unused")
    public QuikDealsPackage() {
        super();
    }

    public QuikDealsPackage(OriginalQuikDealsPackage originalPackage) {
        super(originalPackage);
    }

    @Override
    public QuikDeal createInstanceFromQuikSource(OriginalQuikStandardDataObject quikDataObject) {
        return new QuikDeal(quikDataObject);
    }
}
