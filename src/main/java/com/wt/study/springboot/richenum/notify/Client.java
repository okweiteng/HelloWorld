package com.wt.study.springboot.richenum.notify;

public class Client {
    public static void main(String[] args) {
        NotifyTypeEnum notifyType = NotifyTypeEnum.valueOf("SMS");
        if (notifyType.chargeable()) {
            notifyType.getNotifyMechanism().doNotify("该通知是收费的");
        }
    }
}
