package com.baizhi.serviceimpl;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.RandomSaltUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
//查询所有的用户
    public List<User> findAll() {
        List<User> users = userDAO.queryAll();
        return users;
    }
//修改用户的状态
    @Override
    public void modifyUser(User user) {
        userDAO.update(user);
    }

    @Override
//    根据id查询用户的基本信息
    public User findOne(String id) {
        User user = userDAO.queryById(id);
        return user;
    }
//用户修改
    @Override
    public void modifyOne(User user) {
        user.setRegisterTime(new Date());
        userDAO.updateUser(user);
    }
//用户登陆
    @Override
    public User findPhone(User user) {
        User user1 = userDAO.queryUserByphone(user.getPhone());
        if(user1!=null){
            //将传进来的password+查到数据库的盐值 与查到的数据库的存入的密码相比较
            if((user.getPassword()+user1.getSalt()).equals(user1.getPassword())){
                return user;
            }
            throw  new RuntimeException("密码错误");
        }
        throw  new RuntimeException("请输入正确手机号");
    }
//用户注册添加用户信息
    @Override
    public void addUser(User user) {
        //用户id
        user.setUserId(UUID.randomUUID().toString());
        //盐
        String saltCode = RandomSaltUtil.generetRandomSaltCode();
        //加盐
        user.setPassword(user.getPassword()+saltCode);
        //盐值
        user.setSalt(saltCode);
        //用户状态
        user.setUserstatus("正在使用");
        //注册时间
        user.setRegisterTime(new Date());
        userDAO.insert(user);
    }
}
