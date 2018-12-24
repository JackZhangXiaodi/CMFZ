package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import com.baizhi.util.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/guru")
public class GuruController {
    ViewObject viewObject = new ViewObject();
    @Autowired
    private GuruService guruService;
    @RequestMapping("/findAll")
    @ResponseBody
//    展示所有的上师信息
    public List<Guru> findAll(){
        List<Guru> all = guruService.findAll();
        return all;
    }
//    添加上师信息
    @RequestMapping("/add")
    @ResponseBody
    public ViewObject insert(Guru guru, MultipartFile aa, HttpServletRequest request) throws IOException {
        try{
            //获取相对路径
            String realPath = request.getSession().getServletContext().getRealPath("/cmfz_jsp/carousel/pictures");
            //文件上传
            String fileName = aa.getOriginalFilename();//获取文件名
            aa.transferTo(new File(realPath,fileName));
            guru.setGuruPhoto("pictures/"+fileName);
            guruService.addGuru(guru);
            viewObject.setSuccess(true);
            viewObject.setMessage("ADD SUCCESS");
        }catch (Exception e){
            e.printStackTrace();
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }
//    修改上师信息
    @RequestMapping("/update")
    @ResponseBody
    public ViewObject delete(Guru guru){
        try {
            guruService.modifyGuru(guru);
            viewObject.setSuccess(true);
            viewObject.setMessage("SUCCESS!");
        }catch (Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }
//    根据ID查询上师的信息
    @RequestMapping("/findOne")
    @ResponseBody
    public Guru findOne(String guruId){
        Guru one = guruService.findOne(guruId);
        return one;
    }
//   根据Id删除上师
    @RequestMapping("/delete")
    @ResponseBody
    public ViewObject delete(String guruId){
        try {
            guruService.removeGuru(guruId);
            viewObject.setSuccess(true);
            viewObject.setMessage("DELETE SUCCESS!");
        }catch (Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }
}
