package org.jfteam.service;

import org.jfteam.vo.UserVO;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/5 21:11
 */
public interface UserService {

    void add(UserVO userVO) throws Exception;

    UserVO findOne(Integer id) throws Exception;
}
