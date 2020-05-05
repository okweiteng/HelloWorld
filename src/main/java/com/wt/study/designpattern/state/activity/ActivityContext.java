package com.wt.study.designpattern.state.activity;

public class ActivityContext {

    // 持有抽象状态角色引用
    private ActivityState state;

    public void changeState(ActivityState state) {
        this.state = state;
        this.state.setActivityContext(this);
    }

    public boolean saveDraft(Activity activity) {
        // 委托具体的状态角色
        return this.state.saveDraft(activity);
    }

    public boolean enable(Activity activity) {
        return this.state.enable(activity);
    }

    public boolean start(Activity activity) {
        return this.state.start(activity);
    }

    public boolean disable(Activity activity) {
        return this.state.disable(activity);
    }

    public boolean finish(Activity activity) {
        return this.state.finish(activity);
    }

}
