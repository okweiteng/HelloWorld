package com.wt.study.designpattern.chain;

import org.springframework.stereotype.Component;

@Component
public class SalesOrderOrderHandler extends AbstractOrderHandler {
    @Override
    protected void doHandle(OrderHandlerContext context, OrderHandlerChain chain) {
        if (context.getAmount() > 80) {
            context.setAmount(context.getAmount() * 0.8);
        }
        // 调用下一个处理器进行处理
        chain.handle(context);
    }

    @Override
    protected Integer weight() {
        return OrderHandlerWeightEnum.SALES.getCode();
    }
}
