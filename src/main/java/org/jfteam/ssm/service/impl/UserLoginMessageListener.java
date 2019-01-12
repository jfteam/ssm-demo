package org.jfteam.ssm.service.impl;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.jfteam.framework.mq.RocketMQMessage;
import org.jfteam.framework.mq.RocketMQMessageListener;
import org.jfteam.ssm.vo.UserVO;
import org.springframework.stereotype.Component;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/14 21:35
 */
@Component
public class UserLoginMessageListener implements RocketMQMessageListener<UserVO> {
    @Override
    public String getTopic() {
        return "USER_LOGIN";
    }

    @Override
    public String getTags() {
        return "USER_LOGIN";
    }

    @Override
    public ConsumeConcurrentlyStatus onMessage(RocketMQMessage<UserVO> rocketMQMessage) {
        final UserVO body = rocketMQMessage.getBody();
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
