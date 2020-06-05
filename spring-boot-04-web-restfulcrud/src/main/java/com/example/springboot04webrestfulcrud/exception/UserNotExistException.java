package com.example.springboot04webrestfulcrud.exception;

/**
 * @author 李家幸
 * @class 计科三班
 * @create 2019-12-09 16:11
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("用户不存在");
    }
}
