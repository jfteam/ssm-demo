package org.jfteam.service;

import org.jfteam.vo.UserVO;
import org.springframework.http.ResponseEntity;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/5 21:11
 */
public interface UserService {

    void add(UserVO userVO) throws Exception;
}
