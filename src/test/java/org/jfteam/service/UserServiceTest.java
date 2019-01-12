package org.jfteam.service;

import org.jfteam.BaseTest;
import org.jfteam.ssm.service.UserService;
import org.jfteam.ssm.vo.UserVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/20 15:25
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void add() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setUsername("zhangsan" + System.currentTimeMillis());
        userVO.setPassword("123456");
        userVO.setNickname("zhangsana");
        userService.add(userVO);
        Assert.assertTrue(userVO.getId() > 0);
    }

    @Test
    public void findOne() throws Exception {
        Integer id = 1;
        Assert.assertNotNull(userService.findOne(id));
    }
}