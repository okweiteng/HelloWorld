package com.wt.study.springboot.statemachine.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderService {

    // https://www.jianshu.com/c/fcf45a85f359?tdsourcetag=s_pcqq_aiomsg

    @Autowired
    private StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine;

    private AtomicInteger counter = new AtomicInteger(0);
    private Map<Integer, Order> orders = new HashMap<>();

    public Order creat() {
        Order order = new Order(counter.addAndGet(1), OrderStatus.WAIT_PAYMENT);
        orders.put(order.getId(), order);
        return order;
    }

    public Order pay(int id) {
        Order order = orders.get(id);
        System.out.println("threadName=" + Thread.currentThread().getName() + " 尝试支付 id=" + id);
        Message<OrderStatusChangeEvent> message = MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            System.out.println("threadName=" + Thread.currentThread().getName() + " 支付失败, 状态异常 id=" + id);
        }
        return orders.get(id);
    }

    public Order deliver(int id) {
        Order order = orders.get(id);
        System.out.println("threadName=" + Thread.currentThread().getName() + " 尝试发货 id=" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", order).build(), orders.get(id))) {
            System.out.println("threadName=" + Thread.currentThread().getName() + " 发货失败，状态异常 id=" + id);
        }
        return orders.get(id);
    }

    public Order receive(int id) {
        Order order = orders.get(id);
        System.out.println("threadName=" + Thread.currentThread().getName() + " 尝试收货 id=" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build(), orders.get(id))) {
            System.out.println("threadName=" + Thread.currentThread().getName() + " 收货失败，状态异常 id=" + id);
        }
        return orders.get(id);
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    private synchronized boolean sendEvent(Message<OrderStatusChangeEvent> message, Order order) {
        boolean result = false;
        try {
            orderStateMachine.start();
            //添加延迟用于线程安全测试
            Thread.sleep(1000);
            result = orderStateMachine.sendEvent(message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            orderStateMachine.stop();
        }
        return result;
    }
}
