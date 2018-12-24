package com.baizhi.serviceimpl;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDAO albumDAO;
    @Override
    public List<Album> findOne(String id) {
        List<Album> albums = albumDAO.queryByIdAlbum(id);
        return albums;
    }

    @Override
    public Long findCouts() {
        Long aLong = albumDAO.queryTotalCounts();
        return aLong;
    }

    @Override
    public List<Album> findAllByPage(Integer page,Integer rows) {
        List<Album> albums = albumDAO.queryAllByPage(page, rows);
        return albums;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
//  查询所有的专辑
    public List<Album> findAll() {
        List<Album> albums = albumDAO.queryAll();
        return albums;
    }
//添加专辑
    @Override
    public void addAlbum(Album album) {
        album.setId(UUID.randomUUID().toString());
        albumDAO.insert(album);
    }
//删除专辑
    @Override
    public void removeAlbum(String albumId) {
        albumDAO.delete(albumId);
    }
}
