package com.baizhi.entity;

import java.util.Objects;

/**
 *上师
 *
 */
public class Guru {
    private String guruId;
    private String guruName;//上师名字
    private String guruDescribe;//上师的简介
    private String guruPhoto;//上师的头像
    private String guruStatus;//上师的状态

    public Guru() {
        super();
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruDescribe='" + guruDescribe + '\'' +
                ", guruPhoto='" + guruPhoto + '\'' +
                ", guruStatus='" + guruStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guru guru = (Guru) o;
        return Objects.equals(guruId, guru.guruId) &&
                Objects.equals(guruName, guru.guruName) &&
                Objects.equals(guruDescribe, guru.guruDescribe) &&
                Objects.equals(guruPhoto, guru.guruPhoto) &&
                Objects.equals(guruStatus, guru.guruStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guruId, guruName, guruDescribe, guruPhoto, guruStatus);
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruDescribe() {
        return guruDescribe;
    }

    public void setGuruDescribe(String guruDescribe) {
        this.guruDescribe = guruDescribe;
    }

    public String getGuruPhoto() {
        return guruPhoto;
    }

    public void setGuruPhoto(String guruPhoto) {
        this.guruPhoto = guruPhoto;
    }

    public String getGuruStatus() {
        return guruStatus;
    }

    public void setGuruStatus(String guruStatus) {
        this.guruStatus = guruStatus;
    }

    public Guru(String guruId, String guruName, String guruDescribe, String guruPhoto, String guruStatus) {
        this.guruId = guruId;
        this.guruName = guruName;
        this.guruDescribe = guruDescribe;
        this.guruPhoto = guruPhoto;
        this.guruStatus = guruStatus;
    }
}
