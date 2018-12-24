package com.baizhi.util;

import com.baizhi.entity.Album;

import java.util.List;

public class Row {
    private Integer total;
    private List<Album> rows;

    public Row() {
        super();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Album> getRows() {
        return rows;
    }

    public void setRows(List<Album> rows) {
        this.rows = rows;
    }

    public Row(Integer total, List<Album> rows) {
        this.total = total;
        this.rows = rows;
    }
}
