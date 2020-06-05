package com.example.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 李家幸
 * @class 计科三班
 * @create 2020-01-13 17:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int ucode;
    private String username;
    private String sex;
}
