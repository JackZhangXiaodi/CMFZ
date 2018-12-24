package com.baizhi.test;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
public class ArticleTest {
    @Autowired
    private ArticleService articleService;
    @Test
    public void test(){
        Article article = new Article();
        article.setArtId(UUID.randomUUID().toString());
        article.setArtAuthor("zhang");
        article.setArtContent("哇");
        article.setArtDate(new Date());
        article.setArtPicture("/article");
        article.setArtTitle("小可爱的故事");
        articleService.addArticle(article);
    }
    @Test
    public void test2(){
        List<Article> all = articleService.findAll();
        for (Article article : all) {
            System.out.println(article);
        }
    }
}
