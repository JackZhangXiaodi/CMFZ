package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {
    //展示所有的音频
    List<Chapter> findAll();

    //添加专辑所对应的音频
    void addChapter(Chapter chapter);

}
