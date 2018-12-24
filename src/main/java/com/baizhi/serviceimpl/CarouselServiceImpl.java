package com.baizhi.serviceimpl;

import com.baizhi.dao.CarouselDAO;
import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselDAO carouselDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
//展示轮播图
    public List<Carousel> findAll() {
        List<Carousel> carousels = carouselDAO.queryAll();
        return carousels;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Carousel findOne(String carId) {
        Carousel carousel = carouselDAO.queryById(carId);
        return carousel;
    }

    //添加轮播图
    @Override
    public void addCarousel(Carousel carousel) {
        carousel.setCarId(UUID.randomUUID().toString());
        carouselDAO.insert(carousel);
    }
//修改轮播图
    @Override
    public void modifyCarousel(Carousel carousel) {
        carouselDAO.update(carousel);
    }
//删除轮播图
    @Override
    public void removeCarousel(String carId) {
        carouselDAO.delete(carId);
    }
}
