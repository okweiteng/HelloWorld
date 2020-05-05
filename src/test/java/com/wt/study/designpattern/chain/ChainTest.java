package com.wt.study.designpattern.chain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChainTest {

    @Autowired
    private OrderHandlerChain orderHandlerChain;

    @Test
    void handle() {
        OrderHandlerContext order = OrderHandlerContext.builder()
                .orderNo("123456")
                .amount(100D)
                .vipLevel(3)
                .couponNo("111")
                .build();

        orderHandlerChain.handle(order);
        System.out.println("订单最终金额为： " + order.getAmount());
    }
}