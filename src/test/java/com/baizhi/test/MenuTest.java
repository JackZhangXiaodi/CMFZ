package com.baizhi.test;

import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class MenuTest {
    @Autowired
    private MenuDAO menuDAO;
    @Test
    public void test(){
        List<Menu> menus = menuDAO.queryAll();
        for (Menu menu : menus) {
            List<Menu> children = menu.getChildren();
            for (Menu child : children) {
                System.out.println(child);
            }
            System.out.println(menu);
        }
    }
    @Test
    public void test2(){
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }
}
