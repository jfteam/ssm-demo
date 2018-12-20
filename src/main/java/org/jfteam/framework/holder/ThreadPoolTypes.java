package org.jfteam.framework.holder;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/20 20:24
 */
public enum ThreadPoolTypes {
    EMAIL_SEND("email_send", "邮件发送"),
    SMS_SEND("sms_send", "短信发送");

    private String code;
    private String desc;

    ThreadPoolTypes(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ThreadPoolTypes value(String code) {
        for (ThreadPoolTypes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }
}
