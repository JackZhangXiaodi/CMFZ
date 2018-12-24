package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

/**
 *章节表
 */
public class Chapter {
    private String id;//音频ID
    private String name;//音频名字
    private Double chapSize;//音频的大小
    private String chapUrl;//音频的下载路径
    private String albumName;//专辑的名字
    private String duration;//音频的播放时长
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date uploadDate;//音频的上传时间

    public Chapter() {
        super();
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chapSize=" + chapSize +
                ", chapUrl='" + chapUrl + '\'' +
                ", albumName='" + albumName + '\'' +
                ", duration='" + duration + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(id, chapter.id) &&
                Objects.equals(name, chapter.name) &&
                Objects.equals(chapSize, chapter.chapSize) &&
                Objects.equals(chapUrl, chapter.chapUrl) &&
                Objects.equals(albumName, chapter.albumName) &&
                Objects.equals(duration, chapter.duration) &&
                Objects.equals(uploadDate, chapter.uploadDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, chapSize, chapUrl, albumName, duration, uploadDate);
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

    public Double getChapSize() {
        return chapSize;
    }

    public void setChapSize(Double chapSize) {
        this.chapSize = chapSize;
    }

    public String getChapUrl() {
        return chapUrl;
    }

    public void setChapUrl(String chapUrl) {
        this.chapUrl = chapUrl;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Chapter(String id, String name, Double chapSize, String chapUrl, String albumName, String duration, Date uploadDate) {
        this.id = id;
        this.name = name;
        this.chapSize = chapSize;
        this.chapUrl = chapUrl;
        this.albumName = albumName;
        this.duration = duration;
        this.uploadDate = uploadDate;
    }
}
