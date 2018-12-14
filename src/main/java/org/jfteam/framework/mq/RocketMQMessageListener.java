package org.jfteam.framework.mq;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/14 16:40
 */
public interface RocketMQMessageListener<T> {

    String getTopic();

    String getTags();

    ConsumeConcurrentlyStatus onMessage(RocketMQMessage<T> rocketMQMessage);
}
