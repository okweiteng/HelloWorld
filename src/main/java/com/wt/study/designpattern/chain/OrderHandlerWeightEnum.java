package com.wt.study.designpattern.chain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderHandlerWeightEnum {
    /**
     * 订单优惠权重
     */
    COUPON(1, "优惠券"),
    SALES(2, "促销活动"),
    VIP(3, "VIP");

    private Integer code;

    private String desc;
}
