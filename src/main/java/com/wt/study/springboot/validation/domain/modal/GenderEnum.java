package com.wt.study.springboot.validation.domain.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum {
    /**
     * 性别
     */
    MALE("男"), FEMALE("女"), UNKNOWN("未知");

    private String displayName;
}
