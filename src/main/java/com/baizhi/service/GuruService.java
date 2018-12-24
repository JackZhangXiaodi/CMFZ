package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    //展示所有的上师信息
    List<Guru> findAll();
    //根据id查询上师信息
    Guru findOne(String guruId);
    //添加上师的信息
    void addGuru(Guru guru);

    //修改上师的状态
    void modifyGuru(Guru guru);
    //删除
    void removeGuru(String guruId);
}
