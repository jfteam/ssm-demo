package org.jfteam.ssm.web.filter;

import org.jfteam.framework.context.IUserContext;
import org.jfteam.framework.holder.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/20 11:34
 */
public class UserContextFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserContextFilter.class);

    private List<String> exclusionUrls = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        final String exclusionUrls = filterConfig.getInitParameter("exclusionUrls");
        if (StringUtils.hasText(exclusionUrls)) {
            final String[] split = exclusionUrls.split(",");
            this.exclusionUrls = Arrays.asList(split);
        }
    }

    private boolean isExclusion(String url) {
        boolean result = false;
        if (StringUtils.hasText(url)) {
            for (String exclusionUrl : this.exclusionUrls) {
                if (exclusionUrl.indexOf(url) > 0) {
                    result = true;
                    break;
                }
            }
        }
        return result;
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
