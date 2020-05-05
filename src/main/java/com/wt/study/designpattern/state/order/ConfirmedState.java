package com.wt.study.designpattern.state.order;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConfirmedState implements OrderState {
    @Override
    public void confirm(OrderContext orderContext) {
        System.out.println("订单已确认，请勿重复确认");
    }

    @Override
    public void modify(OrderContext orderContext) {
        System.out.println("订单已修改，请再次确认");
        orderContext.changeState(new OrderedState());
    }

    @Override
    public void pay(OrderContext orderContext) {
        System.out.println("订单已支付，无法再修改");
        orderContext.changeState(new LockedState());
    }
}
