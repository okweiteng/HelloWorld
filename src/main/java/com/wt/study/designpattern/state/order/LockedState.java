package com.wt.study.designpattern.state.order;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LockedState implements OrderState {
    @Override
    public void confirm(OrderContext orderContext) {
        System.out.println("订单已锁定，无需确认");
    }

    @Override
    public void modify(OrderContext orderContext) {
        System.out.println("订单已锁定，不能修改");
    }

    @Override
    public void pay(OrderContext orderContext) {
        System.out.println("订单已锁定，勿重复支付");
    }
}
