package com.baizhi.controller;

import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/counter")
public class CounterController {
    @Autowired
    private CounterService counterService;
    @RequestMapping("/findAll")
//  展示用户的所有的计数器
    public List<Counter> findAll(){
        List<Counter> all = counterService.findAll();
        return all;
    }
}
