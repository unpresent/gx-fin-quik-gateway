package ru.gagarkin.gxfin.gate.quik.dto;

public class OrdersPackage extends StandardPackage<Order> {
    @Override
    public Class rowsClass() {
        return Order.class;
    }
}
