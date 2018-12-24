package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    //登陆
    Admin findAdmin(String adminName);
    //根据Id查询所有的
    Admin findOne(String adminId);
    //修改密码
    void modifyPassword(Admin admin);
}
