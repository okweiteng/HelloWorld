package com.wt.study.designpattern.state.activity;

import org.springframework.stereotype.Component;

@Component
public class ActivityFinishState extends ActivityState {
    @Override
    public ActivityStateEnum state() {
        return ActivityStateEnum.FINISH;
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
        return false;
    }

    @Override
    public boolean disable(Activity activity) {
        return false;
    }

    @Override
    public boolean finish(Activity activity) {
        if (isSameStatus(activity)) {
            return false;
        }
        activity.updateState(state());
        //TODO 更新数据库
        return true;
    }
}
