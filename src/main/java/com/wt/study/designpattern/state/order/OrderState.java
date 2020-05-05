package com.wt.study.designpattern.state.order;

public interface OrderState {
    void confirm(OrderContext orderContext);

    void modify(OrderContext orderContext);

    void pay(OrderContext orderContext);
}
