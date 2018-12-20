package org.jfteam.framework.context;

import org.jfteam.framework.holder.ConstantHolder;
import org.jfteam.framework.holder.ThreadPoolHolder;
import org.jfteam.framework.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/14 21:54
 */
public class AppContextLoaderListener extends ContextLoaderListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppContextLoaderListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        MDC.put(ConstantHolder.CommonFieldName.LOG_TRACE_ID, LogUtils.getTraceId());
        super.contextInitialized(event);
        MDC.clear();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
        this.destroyedThreadPool();
    }

    /**
     * 释放所有的线程池
     */
    private void destroyedThreadPool() {
        final Map<String, ExecutorService> executorServiceForAll = ThreadPoolHolder.getExecutorServiceForAll();
        if (CollectionUtils.isEmpty(executorServiceForAll)) {
            final Set<Map.Entry<String, ExecutorService>> entries = executorServiceForAll.entrySet();
            for (Map.Entry<String, ExecutorService> entry : entries) {
                if (entry != null && !entry.getValue().isShutdown()) {
                    entry.getValue().shutdown();
                    LOGGER.info("business thread pool: {} wos shutdown.", entry.getKey());
                }
            }
        }
    }
}
