package org.jfteam.framework.mq;

import java.io.Serializable;

/**
 * created with IntelliJ IDEA.
 * description: RocketMQ的消息实体
 * author:      fengwenping
 * date:        2019/6/23 21:30
 */
public class RocketMQMessage<T> implements Serializable {

    private String topic;

    private String tags;

    private String key;

    private T body;

    public String getTopic() {
        return topic;
    }

    public String getTags() {
        return tags;
    }

    public String getKey() {
        return key;
    }

    public T getBody() {
        return body;
    }

    private RocketMQMessage(Builder<T> builder) {
        topic = builder.topic;
        tags = builder.tags;
        key = builder.key;
        body = builder.body;
    }


    public static final class Builder<T> {
        private String topic;
        private String tags;
        private String key;
        private T body;

        public Builder() {
        }

        public Builder topic(String val) {
            topic = val;
            return this;
        }

        public Builder tags(String val) {
            tags = val;
            return this;
        }

        public Builder key(String val) {
            key = val;
            return this;
        }

        public Builder body(T val) {
            body = val;
            return this;
        }

        public RocketMQMessage build() {
            return new RocketMQMessage(this);
        }
    }
}
