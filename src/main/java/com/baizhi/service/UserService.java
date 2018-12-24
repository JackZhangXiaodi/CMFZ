package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //给管理员展示用户的信息
    List<User> findAll();

    //根据id查询用户的信息
    User findOne(String id);

    //登陆
    User findPhone(User user);

    //修改用户的状态
    void modifyUser(User user);

    //用户修改自己的信息
    void modifyOne(User user);

    //添加用户信息
    void addUser(User user);
}
