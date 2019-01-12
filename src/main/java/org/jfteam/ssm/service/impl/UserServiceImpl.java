package org.jfteam.ssm.service.impl;

import org.jfteam.ssm.dao.UserMapper;
import org.jfteam.ssm.service.UserService;
import org.jfteam.ssm.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/14 21:34
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(UserVO userVO) throws Exception {
        userMapper.insert(userVO);
    }

    @Override
    public UserVO findOne(Integer id) throws Exception {
        return userMapper.findOne(id);
    }
}
