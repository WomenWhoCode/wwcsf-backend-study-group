package com.designpatterns.structural.bridge;

import java.util.Map;

public abstract class Order {

    // abstract and concrete methods
    public Payment payment;

    abstract public void addItems(Map<Double, String> itemList);

    abstract public Double calculateOrderTotal();

    public Order(Payment payment) {
        this.payment = payment;
    }
}