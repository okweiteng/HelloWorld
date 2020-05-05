package com.wt.study.designpattern.state.order;

public class OrderContext {

    private OrderState state;

    public OrderContext() {
        this.state = new OrderedState();
    }

    void changeState(OrderState orderState) {
        this.state = orderState;
    }

    public void confirm() {
        this.state.confirm(this);
    }

    public void modify() {
        this.state.modify(this);
    }

    public void pay() {
        this.state.pay(this);
    }
}
