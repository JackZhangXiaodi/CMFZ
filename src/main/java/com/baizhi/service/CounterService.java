package com.baizhi.service;

import com.baizhi.entity.Counter;

import java.util.List;

public interface CounterService {
    //展示每个用户中的课程中的计时器信息
    List<Counter> findAll();
}
