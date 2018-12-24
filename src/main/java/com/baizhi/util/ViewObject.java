package com.baizhi.util;

import com.baizhi.entity.Album;

import java.util.List;

public class ViewObject {
    private boolean success;
    private String message;
    private List<Album> rows;//每页条数
    private Integer page;//当前页
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Album> getRows() {
        return rows;
    }

    public void setRows(List<Album> rows) {
        this.rows = rows;
    }

    public ViewObject(boolean success, String message, List<Album> rows, Integer page) {
        this.success = success;
        this.message = message;
        this.rows = rows;
        this.page = page;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ViewObject(String message) {
        this.message = message;
    }

    public ViewObject() {
        super();
    }

    public ViewObject(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
