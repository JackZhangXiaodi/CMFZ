package com.baizhi.serviceimpl;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Admin findOne(String adminId) {
        Admin admin = adminDAO.queryById(adminId);
        return admin;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findAdmin(String  adminName) {
        Admin admin1 = adminDAO.querytByUserName(adminName);
       /* //判断用户名是否正确
        if(admin1!=null){
            if(admin1.getPassword().equals(admin.getPassword())){
                return admin1;
            }
                throw new RuntimeException("密码错误");
        }
        throw new RuntimeException("该用户不存在");*/
       return admin1;
    }
    @Override
//  修改管理员密码
    public void modifyPassword(Admin admin) {
        adminDAO.update(admin);
    }
}
