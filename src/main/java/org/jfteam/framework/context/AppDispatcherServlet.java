package org.jfteam.framework.context;

import org.jfteam.framework.holder.ConstantHolder;
import org.jfteam.framework.util.LogUtils;
import org.slf4j.MDC;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/14 21:59
 */
public class AppDispatcherServlet extends DispatcherServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        MDC.put(ConstantHolder.CommonFieldName.LOG_TRACE_ID, LogUtils.getTraceId());
        super.init(config);
        MDC.clear();
    }
}
