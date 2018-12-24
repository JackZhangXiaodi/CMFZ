package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.List;

public interface CarouselService {
    //展示轮播图
    List<Carousel> findAll();

    //根据轮播图Id查询
    Carousel findOne(String carId);

    //上传轮播图
    void addCarousel(Carousel carousel);

    //轮播图的修改
    void modifyCarousel(Carousel carousel);

    //轮播图的删除
    void removeCarousel(String carId);
}
