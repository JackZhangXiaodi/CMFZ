package com.baizhi.serviceimpl;

import com.baizhi.dao.ArticleDAO;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDAO articleDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
//查询所有的文章
    public List<Article> findAll() {
        List<Article> articles = articleDAO.queryAll();
        return articles;
    }
//添加文章信息
    @Override
    public void addArticle(Article article) {
        article.setArtId(UUID.randomUUID().toString());
        articleDAO.insert(article);
    }
//根据文章的id来删除不需要的文章
    @Override
    public void removeArticle(String artId) {
        articleDAO.delete(artId);
    }
}
