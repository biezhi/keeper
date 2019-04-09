package com.example.keeper.config;

import com.example.keeper.model.Response;
import io.github.biezhi.keeper.exception.KeeperException;
import io.github.biezhi.keeper.exception.UnauthenticException;
import io.github.biezhi.keeper.exception.UnauthorizedException;
import io.github.biezhi.keeper.exception.WrongPasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UnauthorizedException.class)
    public Response<String> defaultErrorHandler(UnauthorizedException e) {
        log.warn(e.getMessage());
        return Response.<String>builder().data("您没有权限访问").build();
    }

    @ExceptionHandler(value = WrongPasswordException.class)
    public Response<String> defaultErrorHandler(WrongPasswordException e) {
        log.warn(e.getMessage());
        return Response.<String>builder().data("错误的密码").build();
    }

    @ExceptionHandler(value = UnauthenticException.class)
    public Response<String> defaultErrorHandler(UnauthenticException e) {
        log.warn(e.getMessage());
        return Response.<String>builder().data("请登录后访问").build();
    }

    @ExceptionHandler(value = Exception.class)
    public Response<String> defaultErrorHandler(Exception e) {
        log.warn("请求发生异常: {}", e.getMessage());
        return Response.<String>builder().code(500).data(e.getMessage()).build();
    }

}