package com.wt.study.designpattern.chain;

public abstract class AbstractOrderHandler {
    protected abstract void doHandle(OrderHandlerContext context, OrderHandlerChain chain);

    /**
     * 订单处理器的权重
     */
    protected abstract Integer weight();
}
