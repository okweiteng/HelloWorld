package com.wt.study.designpattern.state.order;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderedState implements OrderState {
    @Override
    public void confirm(OrderContext orderContext) {
        System.out.println("订单已确认");
        orderContext.changeState(new ConfirmedState());
    }

    @Override
    public void modify(OrderContext orderContext) {
        System.out.println("订单已修改");
        orderContext.changeState(this);
    }

    @Override
    public void pay(OrderContext orderContext) {
        System.out.println("预定状态无法完成订单！");
    }
}
