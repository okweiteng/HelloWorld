package com.wt.study.designpattern.state.activity;

import java.util.Objects;

public abstract class ActivityState {

    // 抽象状态角色需要持有环境上下文对象
    protected ActivityContext activityContext;

    public void setActivityContext(ActivityContext activityContext) {
        this.activityContext = activityContext;
    }

    protected boolean isSameStatus(Activity activity) {
        return Objects.equals(this.state(), activity.getState());
    }

    public abstract ActivityStateEnum state();

    public abstract boolean saveDraft(Activity activity);

    public abstract boolean enable(Activity activity);

    public abstract boolean start(Activity activity);

    public abstract boolean disable(Activity activity);

    public abstract boolean finish(Activity activity);


}
