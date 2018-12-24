package com.baizhi.util;

import java.util.List;

public interface BaseDAO<T> {
    //查询所有
    List<T>  queryAll();

    //根据Id查询所有
    T queryById(String id);

    //添加
    void insert(T t);

    //修改
    void update(T t);

    //删除
    void delete(String id);
}
