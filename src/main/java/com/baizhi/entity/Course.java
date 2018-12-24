package com.baizhi.entity;

import java.util.Objects;

/**
 * 功课
 */
public class Course {
    private String courseId;
    private String courseName;//功课的名字
    private String couriconCls;//功课的小图示
    private String marking;//功课的标识

    public Course() {
        super();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", couriconCls='" + couriconCls + '\'' +
                ", marking='" + marking + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(couriconCls, course.couriconCls) &&
                Objects.equals(marking, course.marking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, couriconCls, marking);
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCouriconCls() {
        return couriconCls;
    }

    public void setCouriconCls(String couriconCls) {
        this.couriconCls = couriconCls;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public Course(String courseId, String courseName, String couriconCls, String marking) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.couriconCls = couriconCls;
        this.marking = marking;
    }
}
