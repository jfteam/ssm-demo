package org.jfteam.web.interceptor;

import org.jfteam.framework.holder.ConstantHolder;
import org.jfteam.framework.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 描述
 * @author: Administrator
 * @date: 2018/11/24 15:21
 */
public class MonitorInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorInterceptor.class);

    private ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        this.startWatch(httpServletRequest);
        LOGGER.info("request url: {}", httpServletRequest.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        httpServletResponse.addHeader(ConstantHolder.CommonFieldName.LOG_TRACE_RESPONSE_HEADER, MDC.get(ConstantHolder.CommonFieldName.LOG_TRACE_ID));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        this.stopWatch();
    }

    private void stopWatch() {
        StopWatch stopWatch = stopWatchThreadLocal.get();
        if (stopWatch != null) {
            stopWatch.stop();
            long totalTimeMillis = stopWatch.getTotalTimeMillis();
            LOGGER.info("request url time elapsed: {}ms", totalTimeMillis);
        }
        stopWatchThreadLocal.remove();
        MDC.clear();
    }

    private void startWatch(HttpServletRequest httpServletRequest) {
        MDC.put(ConstantHolder.CommonFieldName.LOG_TRACE_ID, LogUtils.getTraceId());
        StopWatch stopWatch = new StopWatch(httpServletRequest.getRequestURI() + System.currentTimeMillis());
        stopWatchThreadLocal.set(stopWatch);
        stopWatch.start();
    }
}
