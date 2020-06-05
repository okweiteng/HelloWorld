package com.wt.study.springboot.validation.adapter.form;

import com.wt.study.springboot.validation.application.config.annotation.Region;
import com.wt.study.springboot.validation.domain.modal.GenderEnum;
import com.wt.study.springboot.validation.domain.param.PersonParams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PersonForm implements PersonParams {
    private Long id;
    @NotNull
    private String name;
    private GenderEnum gender;
    private Integer age;

    private String telephone;
    private String email;

    @Region
    private String region;
}
