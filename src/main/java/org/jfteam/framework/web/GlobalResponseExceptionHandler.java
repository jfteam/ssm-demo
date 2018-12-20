package org.jfteam.framework.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/20 22:23
 */
@ControllerAdvice
public class GlobalResponseExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<Object> handleException(Exception exp, WebRequest request) throws IOException {
//        ResponseResult responseResult = new ResponseResult.Builder().build();
//        return handleExceptionInternal(exp, responseResult, new HttpHeaders(), HttpStatus.OK, request);
//    }
}
