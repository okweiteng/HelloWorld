package com.wt.study.springboot.validation.adapter.controller;

import com.wt.study.springboot.validation.adapter.form.PersonForm;
import com.wt.study.springboot.validation.application.service.PersonAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@RestController
@RequestMapping("people")
@Validated
public class PersonController {

    private final PersonAppService appService;

    @Autowired
    public PersonController(PersonAppService appService) {
        this.appService = appService;
    }

    @GetMapping("{id}")
    public void findById(@PathVariable @Valid @Max(value = 5, message = "超过 id 的范围了") Long id) {
        appService.findById(id);
    }

    @PostMapping()
    public void create(@RequestBody @Valid PersonForm form) {
        appService.createPerson(form);
    }
}
