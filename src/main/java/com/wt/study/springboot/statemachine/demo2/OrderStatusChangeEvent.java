package com.wt.study.springboot.statemachine.demo2;

public enum OrderStatusChangeEvent {
    // 支付，发货，确认收货
    PAYED,
    DELIVERY,
    RECEIVED;
}
