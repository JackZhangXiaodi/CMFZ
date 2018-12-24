package com.baizhi.service;

import com.baizhi.entity.Article;

import java.util.List;

public interface ArticleService {
    //查询所有的文章
    List<Article> findAll();

    //添加文章的信息
    void addArticle(Article article);

    //删除文章的信息
    void removeArticle(String artId);

}
