package com.baizhi.dao;

import com.baizhi.entity.Admin;
import com.baizhi.util.BaseDAO;

public interface AdminDAO extends BaseDAO<Admin> {
    //登陆
    Admin querytByUserName(String username);
}
