package com.wt.study.designpattern.state.activity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ActivityStateFactory implements ApplicationContextAware {

    public static final Map<ActivityStateEnum, ActivityState> STATE_MAP = new HashMap<>(ActivityStateEnum.values().length);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ActivityState> beans = applicationContext.getBeansOfType(ActivityState.class);
        beans.values().forEach(item -> STATE_MAP.put(item.state(), item));
    }
}
