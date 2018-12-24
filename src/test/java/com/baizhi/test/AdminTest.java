package com.baizhi.test;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
public class AdminTest {
    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private AdminService adminService;
    @Test
    public void test(){
        Admin admin = adminDAO.querytByUserName("zhangxiaodi");
        System.out.println(admin);
    }
    @Test
    public void test2(){
        Admin admin = new Admin();
        admin.setAdminName("zhangxiaodi");
        Admin admin1 = adminService.findAdmin(admin.getAdminName());
        System.out.println(admin1);
    }
    @Test
    public void test3(){
        Admin admin = new Admin();
        admin.setAdminId("1");
        admin.setPassword("973721");
        adminService.modifyPassword(admin);
    }
    @Test
    public void test4(){
        Md5Hash md5Hash = new Md5Hash("20010601","ABCD");
        System.out.println(md5Hash);
    }
}
