package org.jfteam.framework.util;

import org.jfteam.framework.holder.ConstantHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @description: json工具类, json和对象之间互转
 * @author: fengwenping
 * @date: 2018/12/19 17:35
 */
public final class WebUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebUtils.class);

    public static void buildHeader(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        final String accept = httpServletRequest.getHeader("Accept");
        if (StringUtils.hasText(accept)) {
            final String lowerCase = accept.toLowerCase();
            if (lowerCase.contains(MediaType.TEXT_HTML_VALUE)) {
                httpServletResponse.setContentType(MediaType.TEXT_HTML_VALUE);
            } else if (lowerCase.contains(MediaType.APPLICATION_XML_VALUE)) {
                httpServletResponse.setContentType(MediaType.APPLICATION_XML_VALUE);
            } else {
                httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            }
            return;
        }
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

    public static int getContentLength(String json) {
        try {
            return StringUtils.hasText(json) ? json.getBytes(ConstantHolder.SystemConstants.DEFAULT_CHARSET).length : 0;
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("get content length failure.", e);
        }
        return 0;
    }

    /**
     * 输出json到前端
     *
     * @param httpServletResponse
     * @param object
     * @throws Exception
     */
    public static void writeContent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        WebUtils.buildHeader(httpServletRequest, httpServletResponse);
        final String json = JSONUtils.toJSONString(object);
        httpServletResponse.setCharacterEncoding(ConstantHolder.SystemConstants.DEFAULT_CHARSET);
        httpServletResponse.setContentLength(getContentLength(json));
        httpServletResponse.setHeader("Pragma", "No-cache");
        httpServletResponse.setHeader("Cache-Control", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        ServletOutputStream outputStream = null;
        try {
            outputStream = httpServletResponse.getOutputStream();
            outputStream.write(json.getBytes(ConstantHolder.SystemConstants.DEFAULT_CHARSET));
            outputStream.flush();
        } catch (IOException e) {
            LOGGER.error("output json data to client failure.", e);
        } finally {
            close(outputStream);
        }
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                LOGGER.error("close output stream failure.", e);
            }
        }
    }
}
