package com.baizhi.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 计数器
 */
public class Counter {
    private String counterId;
    private String counterName;//计数器的名字
    private Date counterDate;//创建计数器的时间
    private Integer counterCounts;//计数
    private String userId;//根据用户的的添加的计数器展示
    private String courseId;//根据课程id查询计数器

    public Counter(String counterId, String counterName, Date counterDate, Integer counterCounts, String userId, String courseId) {
        this.counterId = counterId;
        this.counterName = counterName;
        this.counterDate = counterDate;
        this.counterCounts = counterCounts;
        this.userId = userId;
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Counter() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter counter = (Counter) o;
        return Objects.equals(counterId, counter.counterId) &&
                Objects.equals(counterName, counter.counterName) &&
                Objects.equals(counterDate, counter.counterDate) &&
                Objects.equals(counterCounts, counter.counterCounts) &&
                Objects.equals(userId, counter.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(counterId, counterName, counterDate, counterCounts, userId);
    }

    @Override
    public String toString() {
        return "Counter{" +
                "counterId='" + counterId + '\'' +
                ", counterName='" + counterName + '\'' +
                ", counterDate=" + counterDate +
                ", counterCounts=" + counterCounts +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCounterId() {
        return counterId;
    }

    public void setCounterId(String counterId) {
        this.counterId = counterId;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public Date getCounterDate() {
        return counterDate;
    }

    public void setCounterDate(Date counterDate) {
        this.counterDate = counterDate;
    }

    public Integer getCounterCounts() {
        return counterCounts;
    }

    public void setCounterCounts(Integer counterCounts) {
        this.counterCounts = counterCounts;
    }

    public Counter(String counterId, String counterName, Date counterDate, Integer counterCounts, String userId) {
        this.counterId = counterId;
        this.counterName = counterName;
        this.counterDate = counterDate;
        this.counterCounts = counterCounts;
        this.userId = userId;
    }
}
