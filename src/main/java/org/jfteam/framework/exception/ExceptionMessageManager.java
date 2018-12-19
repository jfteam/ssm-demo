package org.jfteam.framework.exception;

import org.jfteam.framework.holder.AppContextHolder;
import org.jfteam.framework.holder.ConstantHolder;
import org.jfteam.framework.holder.PropertyHolderConfigurer;

import java.text.MessageFormat;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/19 14:55
 */
public final class ExceptionMessageManager {

    private static PropertyHolderConfigurer propertyHolderConfigurer;

    private static PropertyHolderConfigurer getPropertyHolderConfigurer() {
        if (propertyHolderConfigurer == null) {
            synchronized (ExceptionMessageManager.class) {
                if (propertyHolderConfigurer == null) {
                    propertyHolderConfigurer = AppContextHolder.getContext().getBean("exceptionProperties", PropertyHolderConfigurer.class);
                }
            }
        }
        return propertyHolderConfigurer;
    }

    public static String getMessage(String errorCode) {
        final PropertyHolderConfigurer properties = ExceptionMessageManager.getPropertyHolderConfigurer();
        return properties.getProperty(errorCode, "");
    }

    public static String getMessage(String errorCode, Object... args) {
        return MessageFormat.format(getMessage(errorCode), args);
    }

    public static String getSuccessMessage() {
        return getMessage(ConstantHolder.ResponseResultCodes.SUCCESS);
    }

    public static String getFailureMessage() {
        return getMessage(ConstantHolder.ResponseResultCodes.FAILURE);
    }

    /**
     * 获取异常到栈信息
     *
     * @param throwable
     * @return
     */
    public static String getExceptionMessage(Throwable throwable) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] trace = throwable.getStackTrace();
        for (StackTraceElement s : trace) {
            stringBuffer.append("\tat ").append(s).append("\r\n");
        }
        return stringBuffer.toString();
    }
}
