package com.wt.study.designpattern.state.activity;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ActivityDisableState extends ActivityState {

    @Resource
    private ActivityEnableState activityEnableState;

    @Override
    public ActivityStateEnum state() {
        return ActivityStateEnum.DISABLE;
    }

    @Override
    public boolean saveDraft(Activity activity) {
        return false;
    }

    @Override
    public boolean enable(Activity activity) {
        this.activityContext.changeState(activityEnableState);
        return this.activityContext.enable(activity);
    }

    @Override
    public boolean start(Activity activity) {
        return false;
    }

    @Override
    public boolean disable(Activity activity) {
        if (isSameStatus(activity)) {
            return false;
        }
        activity.updateState(state());
        // 更新数据库
        return true;
    }

    @Override
    public boolean finish(Activity activity) {
        return false;
    }
}
