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
}
