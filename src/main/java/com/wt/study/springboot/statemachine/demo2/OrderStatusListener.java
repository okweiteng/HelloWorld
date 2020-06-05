package com.wt.study.springboot.statemachine.demo2;

import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@WithStateMachine(name = "orderStateMachine")
public class OrderStatusListener {

    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public boolean payTransition(Message<OrderStatusChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        Assert.notNull(order, "对象不能为空");
        order.updateStatus(OrderStatus.WAIT_DELIVER);
        System.out.println("支付 headers=" + message.getHeaders().toString());
        return true;
    }

    @OnTransition(source = "WAIT_DELIVER", target = "WAIT_RECEIVE")
    public boolean deliverTransition(Message<OrderStatusChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        Assert.notNull(order, "对象不能为空");
        order.updateStatus(OrderStatus.WAIT_RECEIVE);
        System.out.println("发货 headers=" + message.getHeaders().toString());
        return true;
    }

    @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
    public boolean receiveTransition(Message<OrderStatusChangeEvent> message){
        Order order = (Order) message.getHeaders().get("order");
        Assert.notNull(order, "对象不能为空");
        order.updateStatus(OrderStatus.FINISH);
        System.out.println("收货 headers=" + message.getHeaders().toString());
        return true;
    }
}
