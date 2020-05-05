package com.wt.study.designpattern.state.activity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActivityStateEnum {

    /**
     * 活动状态
     */
    DRAFT(1, "草稿箱"),

    ENABLE(2, "已启用"),

    START(3, "进行中"),

    DISABLE(4, "已停用"),

    FINISH(5, "已结束");

    private Integer code;

    private String desc;
}
