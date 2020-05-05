package com.wt.study.designpattern.state.activity;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ActivityStartState extends ActivityState {
    @Resource
    private ActivityDisableState activityDisableState;

    @Resource
    private ActivityFinishState activityFinishState;

    @Override
    public ActivityStateEnum state() {
        return ActivityStateEnum.START;
    }

    @Override
    public boolean saveDraft(Activity activity) {
        return false;
    }

    @Override
    public boolean enable(Activity activity) {
        return false;
    }

    @Override
    public boolean start(Activity activity) {
        if (isSameStatus(activity)) {
            return false;
        }
        activity.updateState(state());
        //TODO 更新数据库
        return true;
    }

    @Override
    public boolean disable(Activity activity) {
        super.activityContext.changeState(activityDisableState);
        return this.activityContext.disable(activity);
    }

    @Override
    public boolean finish(Activity activity) {
        super.activityContext.changeState(activityFinishState);
        return this.activityContext.finish(activity);
    }
}
