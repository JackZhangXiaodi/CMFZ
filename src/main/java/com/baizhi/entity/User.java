package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;
/**
 *用户类
 */
public class User {
    private String userId;
    private String phone;//手机号
    private String name;//用户名
    private String password;//密码
    private String dharmaName;//法名
    private String sex;//性别
    private String province;//省
    private String city;//市
    private String photo;//用户头像
    private String autogroaph;//用户签名
    private String userstatus;//用户状态
    private String salt;//盐值
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerTime;//用户的注册时间

    public User() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(dharmaName, user.dharmaName) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(province, user.province) &&
                Objects.equals(city, user.city) &&
                Objects.equals(photo, user.photo) &&
                Objects.equals(autogroaph, user.autogroaph) &&
                Objects.equals(userstatus, user.userstatus) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(registerTime, user.registerTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, phone, name, password, dharmaName, sex, province, city, photo, autogroaph, userstatus, salt, registerTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", photo='" + photo + '\'' +
                ", autogroaph='" + autogroaph + '\'' +
                ", userstatus='" + userstatus + '\'' +
                ", salt='" + salt + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAutogroaph() {
        return autogroaph;
    }

    public void setAutogroaph(String autogroaph) {
        this.autogroaph = autogroaph;
    }

    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User(String userId, String phone, String name, String password, String dharmaName, String sex, String province, String city, String photo, String autogroaph, String userstatus, String salt, Date registerTime) {
        this.userId = userId;
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.dharmaName = dharmaName;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.photo = photo;
        this.autogroaph = autogroaph;
        this.userstatus = userstatus;
        this.salt = salt;
        this.registerTime = registerTime;
    }
}
