package com.baizhi.test;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;
    @Test
    public void test(){
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    @Test
    public void test2(){
        User user =new User();
        user.setUserId("1");
        user.setUserstatus("已冻结");
        userService.modifyUser(user);
    }
    @Test
    public void test3(){
        User user = userDAO.queryUserByphone("18479251801");
        System.out.println(user);
    }
}
