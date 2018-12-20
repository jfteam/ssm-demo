package org.jfteam.web.filter;

import org.jfteam.framework.context.IUserContext;
import org.jfteam.framework.holder.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/20 11:34
 */
public class UserContextFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserContextFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final String token = httpServletRequest.getHeader("token");
        final IUserContext userContext = UserContextHolder.build(token);
        UserContextHolder.put(userContext);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            LOGGER.error("after put user info to context on doFilter.", e);
        } finally {
            UserContextHolder.remove();
        }
    }

    @Override
    public void destroy() {

    }
}
