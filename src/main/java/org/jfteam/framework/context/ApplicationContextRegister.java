package org.jfteam.framework.context;

import org.jfteam.framework.holder.AppContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ApplicationContextRegister implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextRegister.class);

    @Value("${application.name}")
    private String appName;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext != null && applicationContext.getParent() == null) {
            synchronized (this) {
                AppContextHolder.setContext(applicationContext);
                if (StringUtils.hasText(appName)) {
                    AppContextHolder.setAppName(this.appName);
                }
                String env = applicationContext.getEnvironment().getActiveProfiles()[0];
                if (!StringUtils.hasText(env)) {
                    env = System.getProperty("spring.profiles.active");
                }
                if (StringUtils.hasText(env)) {
                    AppContextHolder.setEnv(env);
                }
            }
        }
        LOGGER.info("Application was initialized, app name is: {}, current env is: {}", AppContextHolder.getAppName(), AppContextHolder.getEnv());
    }
}
