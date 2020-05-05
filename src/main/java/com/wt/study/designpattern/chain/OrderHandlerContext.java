package com.wt.study.designpattern.chain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderHandlerContext {
    // 当前处理器位于处理器chain上的位置
    private int pos;
    // 订单号
    private String orderNo;
    // 订单金额
    private Double amount;
    // VIP等级
    private Integer vipLevel;
    // 优惠券
    private String couponNo;

}
