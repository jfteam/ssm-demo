package org.jfteam.ssm.service;

import org.jfteam.ssm.vo.UserVO;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/5 21:11
 */
public interface UserService {

    void add(UserVO userVO) throws Exception;

    UserVO findOne(Integer id) throws Exception;

    void sendMail(String mailTo, String subject, String content) throws Exception;
}
