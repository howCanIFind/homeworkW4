package com.sparta.homeworkw4.controller;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceController {
    @ExceptionHandler(DuplicateKeyException.class)
    public String custom() {
        return "중복된 사용자 ID 가 존재합니다.";
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String custom2() {
        return "아이디 형식에 맞지 않습니다.";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String custom3() {
        return "비밀번호 형식에 맞지 않습니다.";
    }
}
