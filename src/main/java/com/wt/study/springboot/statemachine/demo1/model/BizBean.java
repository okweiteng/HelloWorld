package com.wt.study.springboot.statemachine.demo1.model;

import com.wt.study.springboot.statemachine.demo1.machine.States;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@WithStateMachine
@Slf4j
@Component
public class BizBean {
    private String status = States.DRAFT.name();

    @OnTransition(target = "PUBLISH_TODO")
    public void online() {
        log.info("操作上线，待发布. target status:{}", States.PUBLISH_TODO.name());
        this.status = States.PUBLISH_TODO.name();
    }

    @OnTransition(target = "PUBLISH_DONE")
    public void publish() {
        log.info("操作发布,发布完成. target status:{}", States.PUBLISH_DONE.name());
        this.status = States.PUBLISH_DONE.name();
    }

    @OnTransition(target = "DRAFT")
    public void rollback() {
        log.info("操作回滚,回到草稿状态. target status:{}", States.DRAFT.name());
        this.status = States.DRAFT.name();
    }
}
