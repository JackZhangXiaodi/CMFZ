package com.baizhi.test;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
public class CarouselTest {
    @Autowired
    private CarouselService carouselService;
    @Test
    public void test(){
        Carousel carousel =new Carousel();
        carousel.setCarId(UUID.randomUUID().toString());
        carousel.setCarName("zhang");
        carousel.setCarPicture("/carousel");
        carousel.setCarStatus("与i");
        carouselService.addCarousel(carousel);
    }
    @Test
    public void test2(){
        List<Carousel> all = carouselService.findAll();
        for (Carousel carousel : all) {
            System.out.println(carousel);
        }
    }
    @Test
    public void test3(){
        Carousel carousel =new Carousel();
        carousel.setCarId("895b9bda-8711-4f50-809f-d7d0e2844656");
        carousel.setCarName("jack");
        carousel.setCarPicture("/carousel");
        carousel.setCarStatus("与i");
        carouselService.modifyCarousel(carousel);
    }
}
