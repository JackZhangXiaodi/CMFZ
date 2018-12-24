package com.baizhi.util;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class MyRealm extends AuthenticatingRealm {
    @Autowired
    private AdminService adminService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        强制类型转换
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
//        获取用户所输入的身份信息
        String username = upToken.getUsername();
//        从数据库中获取用户信息
        Admin admin = adminService.findAdmin(username);
        if(admin.getAdminName().equals(username)){
            return new SimpleAccount(admin.getAdminName(),
                    admin.getPassword(),
                    ByteSource.Util.bytes(admin.getSalt()),
                    UUID.randomUUID().toString());
        }
        return null;
    }
}
