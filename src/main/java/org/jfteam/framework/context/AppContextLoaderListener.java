package org.jfteam.framework.context;

import org.jfteam.framework.holder.ConstantHolder;
import org.jfteam.framework.util.LogUtils;
import org.slf4j.MDC;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/14 21:54
 */
public class AppContextLoaderListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        MDC.put(ConstantHolder.CommonFieldName.LOG_TRACE_ID, LogUtils.getTraceId());
        super.contextInitialized(event);
        MDC.clear();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }
}
