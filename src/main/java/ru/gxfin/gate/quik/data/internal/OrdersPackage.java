package ru.gxfin.gate.quik.data.internal;

import ru.gxfin.gate.quik.data.income.QuikStandardDataObject;
import ru.gxfin.gate.quik.data.income.QuikStandardDataPackage;

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
