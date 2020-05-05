package com.wt.study.designpattern.chain;

public class CouponOrderOrderHandler extends AbstractOrderHandler {
    @Override
    protected void doHandle(OrderHandlerContext context, OrderHandlerChain chain) {
        if (context.getCouponNo() != null) {
            context.setAmount(context.getAmount() - 10);
        }
        // 调用下一个处理器进行处理
        chain.handle(context);
    }

    @Override
    protected Integer weight() {
        return OrderHandlerWeightEnum.COUPON.getCode();
    }
}
