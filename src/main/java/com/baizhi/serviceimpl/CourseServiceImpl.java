package com.baizhi.serviceimpl;

import com.baizhi.dao.CourseDAO;
import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDAO courseDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
//查询该用户的所有的功课
    public List<Course> findAll() {
        List<Course> courses = courseDAO.queryAll();
        return courses;
    }
}
