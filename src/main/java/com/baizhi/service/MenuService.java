package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuService {
    //在页面展示所有菜单
    List<Menu> findAll();
}
