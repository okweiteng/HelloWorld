package com.wt.study.springboot.richenum.notify;

public abstract class AbstractNotifyMechanism {
    public static AbstractNotifyMechanism byEmail() {
        return new AbstractNotifyMechanism() {
            @Override
            protected boolean send(String template) {
                try {
                    System.out.println("邮件发送，内容是：" + template);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        };
    }

    public static AbstractNotifyMechanism bySms() {
        return new AbstractNotifyMechanism() {
            @Override
            protected boolean send(String template) {
                try {
                    System.out.println("短信发送，内容是：" + template);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        };
    }

    public static AbstractNotifyMechanism byWechat() {
        return new AbstractNotifyMechanism() {
            @Override
            protected boolean send(String template) {
                try {
                    System.out.println("微信发送，内容是：" + template);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        };
    }

    public final boolean doNotify(String message) {
        String template = buildTemplateByChannel(message);
        return send(template);

    }

    protected abstract boolean send(String template);

    private String buildTemplateByChannel(String message) {
        return "Dear customer: " + message;
    }
}
