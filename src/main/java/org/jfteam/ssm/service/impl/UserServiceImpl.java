package org.jfteam.ssm.service.impl;

import org.jfteam.ssm.dao.UserMapper;
import org.jfteam.ssm.service.UserService;
import org.jfteam.ssm.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

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

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void add(UserVO userVO) throws Exception {
        userMapper.insert(userVO);
    }

    @Override
    public UserVO findOne(Integer id) throws Exception {
        return userMapper.findOne(id);
    }

    @Override
    public void sendMail(String[] mailTo, String subject, String content) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom("244160190@163.com");
            helper.setTo(mailTo);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
            LOGGER.info("html格式邮件发送成功");
        } catch (Exception e) {
            LOGGER.error("html格式邮件发送失败", e);
        }
    }
}
