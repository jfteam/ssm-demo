package org.jfteam.framework.util;

import java.util.UUID;

public final class LogUtils {

    /**
     * 获取traceId,32为uuid
     *
     * @return
     */
    public static String getTraceId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取异常到栈信息
     *
     * @param throwable
     * @return
     */
    public static String getExceptionMessage(Throwable throwable) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] trace = throwable.getStackTrace();
        for (StackTraceElement s : trace) {
            stringBuffer.append("\tat ").append(s).append("\r\n");
        }
        return stringBuffer.toString();
    }
}
