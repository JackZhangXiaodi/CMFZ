package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 专辑类
 *
 */
public class Album {
    private String id;//专辑ID
    private String name;//专辑名称
    private String albumAuthor;//专辑作者
    private String albumVoice;//播音员
    private String season;//集数
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;//发布时间
    private String albumPicture;//专辑中的插图
    private String content;//专辑的简介
    private Double score;//评分
    private List<Chapter> children;//专辑中的音频

    public Album() {
        super();
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", albumAuthor='" + albumAuthor + '\'' +
                ", albumVoice='" + albumVoice + '\'' +
                ", season='" + season + '\'' +
                ", createdate=" + createdate +
                ", albumPicture='" + albumPicture + '\'' +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(name, album.name) &&
                Objects.equals(albumAuthor, album.albumAuthor) &&
                Objects.equals(albumVoice, album.albumVoice) &&
                Objects.equals(season, album.season) &&
                Objects.equals(createdate, album.createdate) &&
                Objects.equals(albumPicture, album.albumPicture) &&
                Objects.equals(content, album.content) &&
                Objects.equals(score, album.score) &&
                Objects.equals(children, album.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, albumAuthor, albumVoice, season, createdate, albumPicture, content, score, children);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbumAuthor() {
        return albumAuthor;
    }

    public void setAlbumAuthor(String albumAuthor) {
        this.albumAuthor = albumAuthor;
    }

    public String getAlbumVoice() {
        return albumVoice;
    }

    public void setAlbumVoice(String albumVoice) {
        this.albumVoice = albumVoice;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getAlbumPicture() {
        return albumPicture;
    }

    public void setAlbumPicture(String albumPicture) {
        this.albumPicture = albumPicture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album(String id, String name, String albumAuthor, String albumVoice, String season, Date createdate, String albumPicture, String content, Double score, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.albumAuthor = albumAuthor;
        this.albumVoice = albumVoice;
        this.season = season;
        this.createdate = createdate;
        this.albumPicture = albumPicture;
        this.content = content;
        this.score = score;
        this.children = children;
    }
}
