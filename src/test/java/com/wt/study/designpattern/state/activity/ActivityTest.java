package com.wt.study.designpattern.state.activity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActivityTest {

    @Test
    public void test1() {

        Activity activity = Activity.builder()
                .id(1L)
                .name("测试活动")
                .state(ActivityStateEnum.DRAFT)
                .createTime(LocalDateTime.now())
                .build();

        ActivityState activityState = ActivityStateFactory.STATE_MAP.get(activity.getState());

        ActivityContext context = new ActivityContext();

        context.changeState(activityState);

        System.out.println("保存草稿: " + (context.saveDraft(activity) ? "成功" : "失败"));

        System.out.println("更新活动状态为已启用: " + (context.enable(activity) ? "成功" : "失败"));

        System.out.println("更新活动状态为进行中: " + (context.start(activity) ? "成功" : "失败"));

        System.out.println("更新活动状态为已停用: " + (context.disable(activity) ? "成功" : "失败"));

        System.out.println("更新活动状态为已启用: " + (context.enable(activity) ? "成功" : "失败"));

        System.out.println("更新活动状态为进行中: " + (context.start(activity) ? "成功" : "失败"));

        System.out.println("更新活动状态为已结束: " + (context.finish(activity) ? "成功" : "失败"));

        System.out.println("更新活动状态为进行中: " + (context.start(activity) ? "成功" : "失败"));

    }
}