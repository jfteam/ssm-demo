package org.jfteam.framework.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jfteam.framework.web.HttpStatusProvider;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @description: 统一返回结果实体
 * @author: fengwenping
 * @date: 2018/12/18 14:57
 */
public class ResponseResult implements HttpStatusProvider, Serializable {

    private boolean success;
    private String errorCode;
    private String errorMessage;
    private Object data;

    private ResponseResult(Builder builder) {
        success = builder.success;
        errorCode = builder.errorCode;
        errorMessage = builder.errorMessage;
        data = builder.data;
    }

    @JsonIgnore
    @Override
    public int getHttpCode() {
        return HttpStatus.OK.value();
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Object getData() {
        return data;
    }

    public static final class Builder {
        private boolean success;
        private String errorCode;
        private String errorMessage;
        private Object data;

        public Builder() {
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public ResponseResult build() {
            return new ResponseResult(this);
        }
    }
}
