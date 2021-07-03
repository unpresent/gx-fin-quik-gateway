package ru.gxfin.gate.quik.model.internal;

import ru.gxfin.gate.quik.model.income.QuikStandardDataObject;
import ru.gxfin.gate.quik.model.income.QuikStandardDataPackage;

public class OrdersPackage extends StandardDataPackage<Order> {
    public OrdersPackage() {
        super();
    }

    public OrdersPackage(QuikStandardDataPackage quikDataPackage) {
        super(quikDataPackage);
    }

    /*
    @Override
    public Class rowsClass() {
        return Order.class;
    }
    /*/

    @Override
    public Order createInstanceFromQuikSource(QuikStandardDataObject quikDataObject) {
        return new Order(quikDataObject);
    }
}
