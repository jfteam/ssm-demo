package org.jfteam.framework.holder;

import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

public final class AppContextHolder {
    private static final String DEFAULT_ENVIRONMENT = "dev";

    private static String appName;
    private static String env = DEFAULT_ENVIRONMENT;
    private static ApplicationContext context;

    public static String getAppName() {
        return appName;
    }

    public static void setAppName(String appName) {
        AppContextHolder.appName = appName;
    }

    public static String getEnv() {
        return env;
    }

    public static void setEnv(String env) {
        AppContextHolder.env = env;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        AppContextHolder.context = context;
    }

    public static boolean isDebug() {
        return StringUtils.hasText(env) && DEFAULT_ENVIRONMENT.equalsIgnoreCase(env);
    }
}
