package org.jfteam.ssm.web.controller;

import org.jfteam.framework.exception.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/11/24 18:10
 */
@RestController
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        final String userName = httpServletRequest.getParameter("userName");
        final String password = httpServletRequest.getParameter("password");
        LOGGER.info("userName: {}", userName);
        LOGGER.info("password: {}", password);
        throw new AuthenticationException();
        //httpServletResponse.getWriter().write("userName:" + userName);
    }
}
