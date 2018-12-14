package org.jfteam.framework.mq;

import org.apache.rocketmq.client.producer.SendResult;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/14 16:41
 */
public interface RocketMQMessageSender<T> {

    String getNameSrvAddress();

    String getProducerGroup();

    boolean send(RocketMQMessage<T> rocketMQMessage);

    void onSuccess(SendResult sendResult);

    void onFailure(Throwable throwable);
}
