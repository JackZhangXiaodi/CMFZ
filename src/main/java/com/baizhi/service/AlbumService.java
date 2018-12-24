package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    //展示所有的专辑
    List<Album> findAll();
    //根据Id查询专辑信息
    List<Album> findOne(String id);
    //分页查询
    List<Album> findAllByPage(Integer page,Integer rows);
    //查询数据库中的有效数据条数
    Long findCouts();
    //添加专辑
    void addAlbum(Album album);

    //删除专辑
    void removeAlbum(String albumId);
}
