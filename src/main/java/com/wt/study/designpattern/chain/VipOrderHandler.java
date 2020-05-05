package com.wt.study.designpattern.chain;

import org.springframework.stereotype.Component;

@Component
public class VipOrderHandler extends AbstractOrderHandler{
    @Override
    protected void doHandle(OrderHandlerContext context, OrderHandlerChain chain) {
        if (context.getVipLevel() > 2) {
            context.setAmount(context.getAmount() - 5);
        }
        // 调用下一个处理器进行处理
        chain.handle(context);
    }

    @Override
    protected Integer weight() {
        return OrderHandlerWeightEnum.VIP.getCode();
    }
}
