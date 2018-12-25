package com.baizhi.controller;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    ViewObject viewObject=new ViewObject();
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    @ResponseBody
//展示所有的用户
    public List<User> findAll(){
        List<User> all = userService.findAll();
        return all;
    }
//管理员操作修改用户的状态
    @RequestMapping("/update")
    @ResponseBody
    public ViewObject update(User user){
        try {
            userService.modifyUser(user);
            viewObject.setSuccess(true);
            viewObject.setMessage("UPDATE SUCCESS");
        }catch (Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }
//用户操作
    @RequestMapping("/showAll")
    public String showAll(Model model){
        List<User> all = userService.findAll();
        model.addAttribute("user",all);
        return "showAll";
    }
    @RequestMapping("/login")
//用户登录
    public String  findPhone(User user, HttpSession session){

        try {
            User user1 = userService.findPhone(user);
            session.setAttribute("user",user1);
            return "redirect:/user/showAll";
        }catch (Exception e){
            return "redirect:/cfmz_jsp/user/Userlogin.jsp";
        }
    }

//用户操作添加用户的信息
    @RequestMapping("/add")
    public String add(User user, MultipartFile file,HttpServletRequest request) throws IOException {
        //获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("cmfz_jsp\\user\\photo");
        String filename = file.getOriginalFilename();
        file.transferTo(new File(realPath,filename));
        user.setPhoto("pictures/"+filename);
        userService.addUser(user);
        return "redirect:/index.jsp";
    }
//用户修改自己个人信息
    @RequestMapping("/updateUser")
    public String modify(User user,MultipartFile file,HttpServletRequest request) throws IOException {

        //获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("cmfz_jsp\\user\\photo");
        String filename = file.getOriginalFilename();
        file.transferTo(new File(realPath,filename));
        System.out.println(user.getUserId());
        User one = userService.findOne(user.getUserId());
        user.setSalt(one.getSalt());
        user.setPassword(user.getPassword()+one.getSalt());
        user.setUserId(user.getUserId());
        user.setPhoto("pictures/"+filename);

        userService.modifyOne(user);
        return "redirect:/user/showAll";
    }
//    查询所有的用户的分布情况
    @RequestMapping("/addr")
    @ResponseBody
    public HashMap<String, Object> findAddr(){
        List<Address> addr = userService.findAddr();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",addr);
        return map;
    }
}
