package com.wt.study.springboot.statemachine.demo2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private Integer id;
    private OrderStatus status;

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }
}
