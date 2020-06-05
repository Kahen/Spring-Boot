package com.example.springboot.mapper;

import com.example.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李家幸
 * @class 计科三班
 * @create 2020-01-13 17:55
 */
public interface UserMapper {
    int deleteByUcode(@Param("ucode") Integer ucode);

    int insert(User user);

    User selectByUcode(@Param("ucode") Integer ucode);

    int updateByUcode(User user);

    List<User> queryAllUser();
}
