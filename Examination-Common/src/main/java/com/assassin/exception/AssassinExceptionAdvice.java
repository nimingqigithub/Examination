package com.assassin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2016/10/24.
 */
@ControllerAdvice
public class AssassinExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(AssassinException.class)
    @ResponseBody
    public AssassinExceptionErrorInfo handleIllegal(AssassinException e) {
        return new AssassinExceptionErrorInfo("Bad request", e);
    }
}
