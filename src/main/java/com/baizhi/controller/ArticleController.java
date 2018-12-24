package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import com.baizhi.util.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    ViewObject viewObject = new ViewObject();
    @Autowired
    private ArticleService articleService;
    //查询所有的文章
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Article> findAll(){
        List<Article> all = articleService.findAll();
        return all;
    }
    //添加文章的信息
    @RequestMapping("/add")
    @ResponseBody
    public ViewObject add(Article article){
        try {
            articleService.addArticle(article);
            viewObject.setSuccess(true);
            viewObject.setMessage("ADD SUCCESS");
        }catch (Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }
    //根据文章的id删除文章
    @RequestMapping("/delete")
    @ResponseBody
    public ViewObject delete(String artId){
        try {
            articleService.removeArticle(artId);
            viewObject.setSuccess(true);
            viewObject.setMessage("DELETE SUCCESS");
        }catch(Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }
}
