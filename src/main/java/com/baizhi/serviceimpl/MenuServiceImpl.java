package com.baizhi.serviceimpl;

import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
//展示菜单列表
    public List<Menu> findAll() {
        List<Menu> menus = menuDAO.queryAll();
        return menus;
    }
}
