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

    @Test
    public void sendMail() throws Exception {
        String mailTo = "244160190@qq.com";
        String subject = "【笔试邀约】平安科技在线笔试邀请函";
        String content = "<table width=\"780px\" style=\"font-size: 12px; font-family: 'Microsoft YaHei'\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td width=\"780px\" style=\"font-size: 12px;color: #424656\">\n" +
                "            <p>亲爱的${候选人姓名}</p>\n" +
                "            <p>&emsp;&emsp;欢迎您参加${专业公司简称}${校招年份}校园招聘笔试,笔试结果将作为进入面试的重要筛选条件，如您无法参加本场考试，视为自动放弃，无其他考试机会，请您慎重对待。</p>\n" +
                "            <p>&emsp;&emsp;具体安排如下：</p>\n" +
                "            <p>&emsp;&emsp;笔试时间：${笔试时间}</p>\n" +
                "            <p>&emsp;&emsp;笔试地点：${笔试地点}</p>\n" +
                "            <p>&emsp;&emsp;请携带身份证提前10分钟到场签到，谢谢！</p>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>";
        userService.sendMail(mailTo, subject, content);
    }
}