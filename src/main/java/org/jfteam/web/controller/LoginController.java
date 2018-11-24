package org.jfteam.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value = "login")
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    }
}
