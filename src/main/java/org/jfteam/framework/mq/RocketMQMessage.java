package org.jfteam.framework.mq;

import java.io.Serializable;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/14 16:36
 */
public class RocketMQMessage<T> implements Serializable {

    private String topic;

    private String tags;

    private String key;

    private T body;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
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
