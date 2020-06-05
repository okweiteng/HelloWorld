package com.wt.study.springboot.validation.domain.param;


import com.wt.study.springboot.validation.domain.modal.GenderEnum;

import javax.validation.constraints.NotNull;

public interface PersonParams {
    Long getId();

    @NotNull
    String getName();

    GenderEnum getGender();

    Integer getAge();

    String getTelephone();

    String getEmail();
}
