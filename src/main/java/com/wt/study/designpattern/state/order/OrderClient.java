package com.wt.study.designpattern.state.order;

import com.wt.study.designpattern.state.order.OrderContext;

public class OrderClient {
    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();
        //已预定状态>已确认状态
        orderContext.confirm();

        //已确认状态>已预定状态
        orderContext.modify();

        //已预定状态>已确认状态
        orderContext.confirm();

        //已确认状态>已锁定状态
        orderContext.pay();

        //已锁定状态
        orderContext.modify();
    }
}
