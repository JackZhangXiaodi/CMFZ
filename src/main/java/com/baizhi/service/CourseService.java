package com.baizhi.service;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {
    //展示必修的课程 和 用户选修的课程的信息
    List<Course> findAll();
}
