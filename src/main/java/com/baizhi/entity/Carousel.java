package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

/**
 * 轮播图
 *
 */
public class Carousel {
    private String carId;
    private String carPicture;//轮播图的图片路径
    private String carName;//轮播图的名字
    private String carStatus;//轮播图的状态
    private String desca;//对轮播图的描述
    @JsonFormat(pattern = "yyyy-MM-dd",timezone ="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date crateTime;//轮播图的上传时间
    public Carousel() {
        super();
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "carId='" + carId + '\'' +
                ", carPicture='" + carPicture + '\'' +
                ", carName='" + carName + '\'' +
                ", carStatus='" + carStatus + '\'' +
                ", desca='" + desca + '\'' +
                ", crateTime=" + crateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carousel carousel = (Carousel) o;
        return Objects.equals(carId, carousel.carId) &&
                Objects.equals(carPicture, carousel.carPicture) &&
                Objects.equals(carName, carousel.carName) &&
                Objects.equals(carStatus, carousel.carStatus) &&
                Objects.equals(desca, carousel.desca) &&
                Objects.equals(crateTime, carousel.crateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, carPicture, carName, carStatus, desca, crateTime);
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarPicture() {
        return carPicture;
    }

    public void setCarPicture(String carPicture) {
        this.carPicture = carPicture;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getDesca() {
        return desca;
    }

    public void setDesca(String desca) {
        this.desca = desca;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Carousel(String carId, String carPicture, String carName, String carStatus, String desca, Date crateTime) {
        this.carId = carId;
        this.carPicture = carPicture;
        this.carName = carName;
        this.carStatus = carStatus;
        this.desca = desca;
        this.crateTime = crateTime;
    }
}
