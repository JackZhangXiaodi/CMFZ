package com.baizhi.dao;

import com.baizhi.entity.Album;
import com.baizhi.util.BaseDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDAO extends BaseDAO<Album> {
    //分页查询
    List<Album> queryAllByPage(@Param("page")Integer page,@Param("rows") Integer rows);

    //查询所有的条数
    Long queryTotalCounts();

    //专辑详情
    List<Album> queryByIdAlbum(String id);
}
