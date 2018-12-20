package org.jfteam.framework.holder;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;


/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/20 19:56
 */
public final class ThreadPoolHolder {

    private static final Map<String, ExecutorService> EXECUTOR_SERVICE_FOR_ALL = new LinkedHashMap<>();

    /**
     * 获取业务线程池
     *
     * @param threadPoolType
     * @return
     */
    public static ExecutorService getBusinessThreadPool(ThreadPoolTypes threadPoolType) {
        Assert.isTrue(threadPoolType != null && StringUtils.hasText(threadPoolType.getCode()), "thread pool type must be not null.");
        final String code = threadPoolType.getCode();
        if (!EXECUTOR_SERVICE_FOR_ALL.containsKey(code) || EXECUTOR_SERVICE_FOR_ALL.get(code).isShutdown()) {
            synchronized (ThreadPoolHolder.class) {
                if (!EXECUTOR_SERVICE_FOR_ALL.containsKey(code) || EXECUTOR_SERVICE_FOR_ALL.get(code).isShutdown()) {
                    ExecutorService executorService = new ThreadPoolExecutor(10, 90, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5000));
                    EXECUTOR_SERVICE_FOR_ALL.put(code, executorService);
                }
            }
        }
        return EXECUTOR_SERVICE_FOR_ALL.get(code);
    }

    public static Map<String, ExecutorService> getExecutorServiceForAll() {
        return EXECUTOR_SERVICE_FOR_ALL;
    }
}
