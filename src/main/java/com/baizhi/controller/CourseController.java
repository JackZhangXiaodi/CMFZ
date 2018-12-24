package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/findAll")
    @ResponseBody
//   展示用户所有的课程
    public List<Course> findAll(){
        List<Course> all = courseService.findAll();
        return all;
    }
}
