package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.util.BaseDAO;
import org.apache.ibatis.annotations.Param;

public interface UserDAO extends BaseDAO<User> {
    //根据名字查询用户
    User queryUserByphone(@Param("phone") String phone);
    //用户修改个人信息
    void updateUser(User user);
}
