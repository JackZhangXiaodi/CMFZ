package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.ViewObject;
import com.sun.deploy.net.HttpResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/login")
    public String login(Admin admin,boolean rememberMe){
        try {
            Subject subject = SecurityUtils.getSubject();
            System.out.println(admin+"--"+rememberMe);
            subject.login(new UsernamePasswordToken(admin.getAdminName(),admin.getPassword(),rememberMe));
        } catch (UnknownAccountException uae){
//            model.addAttribute("error","用户名或者密码错误");
            return "redirect:/login.jsp?adminName='用户名错误'";

        } catch (IncorrectCredentialsException ice){
//            model.addAttribute("error","用户名或者密码错误");
            return "redirect:/login.jsp?password='密码错误'";
        }catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:/login.jsp?aaa='密码错误'";
        }
        return "redirect:/main/main.jsp";
        /*
        try {
            Admin admin1 = adminService.findAdmin(admin.getAdminName());
            session.setAttribute("admin",admin1);
            return "redirect:/main/main.jsp";
        }catch (Exception e){
            model.addAttribute("error","用户名或者密码错误");
            return "login";
        }*/
    }
    @RequestMapping("/update")
    @ResponseBody
    //修改管理者密码
    public ViewObject update(Admin admin, String pwa){
        ViewObject viewObject = new ViewObject();
        try {
            admin.setPassword(pwa);
            adminService.modifyPassword(admin);
            viewObject.setSuccess(true);
            viewObject.setMessage("UPDATE SUCCESS");
        }catch(Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }
//  根据Id查询所有
    @RequestMapping("/findOne")
    @ResponseBody
    public Admin findOne(String adminId){
        Admin one = adminService.findOne(adminId);
        return one;
    }
//安全退出
    @RequestMapping("/out")
    public String out(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/login.jsp";
    }
//  比较旧密码是否正确
    @RequestMapping("/old")
    @ResponseBody
    public ViewObject findOld(String password,HttpSession session){
        ViewObject viewObject = new ViewObject();
        Admin admin = (Admin) session.getAttribute("admin");
        if(admin.getPassword().equals(password)){
            viewObject.setSuccess(true);
            viewObject.setMessage("密码正确");
        }else{
            viewObject.setSuccess(false);
            viewObject.setMessage("密码输入不一致");
        }
        return viewObject;
    }
}
