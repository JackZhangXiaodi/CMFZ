package com.baizhi.controller;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
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
@RequestMapping("/carousel")
public class CarouselController {
    ViewObject viewObject = new ViewObject();
    @Autowired
    private CarouselService carouselService;
    //展示所有的轮播图
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Carousel> findAll(){
        List<Carousel> all = carouselService.findAll();
        return all;
    }
    //添加轮播图
    @RequestMapping("/add")
    @ResponseBody
    public ViewObject insert(Carousel carousel, MultipartFile aa, HttpServletRequest request) throws IOException {
        try{
            System.out.println("+-----------");
            //获取相对路径
            String realPath = request.getSession().getServletContext().getRealPath("/cmfz_jsp/carousel/pictures");
            //文件上传
            String fileName = aa.getOriginalFilename();//获取文件名
            aa.transferTo(new File(realPath,fileName));
            carousel.setCarPicture("pictures/"+fileName);
            carouselService.addCarousel(carousel);
            viewObject.setSuccess(true);
            viewObject.setMessage("ADD SUCCESS");
        }catch (Exception e){
            e.printStackTrace();
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }

    //删除轮播图
    @RequestMapping("/delete")
    @ResponseBody
    public ViewObject delete(String carId){
        try {
            carouselService.removeCarousel(carId);
            viewObject.setSuccess(true);
            viewObject.setMessage("DELETE SUCCESS");
        }catch (Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
            return viewObject;
    }
    //根据ID查询多对应的轮播图
    @RequestMapping("/findOne")
    @ResponseBody
    public Carousel findOne(String carId){
        Carousel one = carouselService.findOne(carId);
        String carPicture = one.getCarPicture();
        one.setCarPicture(carPicture);
        return one;
    }
    //修改轮播图
    @RequestMapping("/update")
    @ResponseBody
    public ViewObject update(Carousel carousel,MultipartFile aaa,HttpServletRequest request){
        try {
            //获取绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("/cmfz_jsp/carousel/pictures");
            //获取上传文件的名称
            String originalFilename = aaa.getOriginalFilename();
            //上传文件
            aaa.transferTo(new File(realPath,originalFilename));
            carousel.setCarPicture("pictures/"+originalFilename);
            carouselService.modifyCarousel(carousel);
            viewObject.setSuccess(true);
            viewObject.setMessage("UPDATE SUCCESS");
        }catch (Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
            return viewObject;
    }

}
