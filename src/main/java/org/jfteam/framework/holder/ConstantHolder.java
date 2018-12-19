package org.jfteam.framework.holder;

public final class ConstantHolder {
    public static class CommonFieldName {
        public static final String LOG_TRACE_ID = "traceId";
        public static final String LOG_TRACE_RESPONSE_HEADER = "RequestId";
    }

    public static class SystemConstants {
        public static final String DEFAULT_CHARSET = "UTF-8";
    }

    public static class ResponseResultCodes {
        //正常响应
        public static final String SUCCESS = "20000";
        //异常响应
        public static final String FAILURE = "40000";
        //未授权
        public static final String AUTHENTICATION = "40100";
        //未登录
        public static final String AUTHORIZATION = "403000";
        //资源未找到
        public static final String NOT_FOUND = "40400";

    }

}
