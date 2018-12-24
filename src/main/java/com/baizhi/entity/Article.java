package com.baizhi.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 文章类
 */
public class Article {
    private String artId;
    private String artTitle;//文章名称
    private String artAuthor;//文章作者
    private Date artDate;//文章的发展时间
    private String artContent;//文章的内容
    private String artPicture;//文章中的插图

    public Article() {
        super();
    }

    @Override
    public String toString() {
        return "Article{" +
                "artId='" + artId + '\'' +
                ", artTitle='" + artTitle + '\'' +
                ", artAuthor='" + artAuthor + '\'' +
                ", artDate=" + artDate +
                ", artContent='" + artContent + '\'' +
                ", artPicture='" + artPicture + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(artId, article.artId) &&
                Objects.equals(artTitle, article.artTitle) &&
                Objects.equals(artAuthor, article.artAuthor) &&
                Objects.equals(artDate, article.artDate) &&
                Objects.equals(artContent, article.artContent) &&
                Objects.equals(artPicture, article.artPicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artId, artTitle, artAuthor, artDate, artContent, artPicture);
    }

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtAuthor() {
        return artAuthor;
    }

    public void setArtAuthor(String artAuthor) {
        this.artAuthor = artAuthor;
    }

    public Date getArtDate() {
        return artDate;
    }

    public void setArtDate(Date artDate) {
        this.artDate = artDate;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }

    public String getArtPicture() {
        return artPicture;
    }

    public void setArtPicture(String artPicture) {
        this.artPicture = artPicture;
    }

    public Article(String artId, String artTitle, String artAuthor, Date artDate, String artContent, String artPicture) {
        this.artId = artId;
        this.artTitle = artTitle;
        this.artAuthor = artAuthor;
        this.artDate = artDate;
        this.artContent = artContent;
        this.artPicture = artPicture;
    }
}
