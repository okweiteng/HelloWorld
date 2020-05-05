package com.wt.study.designpattern.state.activity;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ActivityEnableState extends ActivityState {

    @Resource
    private ActivityDraftState activityDraftState;
    @Resource
    private ActivityStartState activityStartState;
    @Resource
    private ActivityDisableState activityDisableState;


    @Override
    public ActivityStateEnum state() {
        return ActivityStateEnum.ENABLE;
    }

    @Override
    public boolean saveDraft(Activity activity) {
        this.activityContext.changeState(activityDraftState);
        return this.activityContext.saveDraft(activity);
    }

    @Override
    public boolean enable(Activity activity) {
        if (isSameStatus(activity)) {
            return false;
        }
        activity.updateState(state());
        //TODO 更新数据库
        return true;
    }

    @Override
    public boolean start(Activity activity) {
        this.activityContext.changeState(activityStartState);
        return activityContext.start(activity);
    }

    @Override
    public boolean disable(Activity activity) {
        this.activityContext.changeState(activityDisableState);
        return activityContext.disable(activity);
    }

    @Override
    public boolean finish(Activity activity) {
        return false;
    }
}
