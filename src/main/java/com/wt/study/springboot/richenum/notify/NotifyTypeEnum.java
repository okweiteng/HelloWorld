package com.wt.study.springboot.richenum.notify;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotifyTypeEnum {
    /**
     * 充血枚举模型
     */
    EMAIL("邮件", AbstractNotifyMechanism.byEmail()) {
        @Override
        public boolean chargeable() {
            return false;
        }
    },
    SMS("短信", AbstractNotifyMechanism.bySms()) {
        @Override
        public boolean chargeable() {
            return true;
        }
    },
    WECHAT("微信", AbstractNotifyMechanism.byWechat()) {
        @Override
        public boolean chargeable() {
            return false;
        }
    };

    private String displayName;
    private AbstractNotifyMechanism notifyMechanism;

    public abstract boolean chargeable();
}
