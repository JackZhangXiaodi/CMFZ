package com.baizhi.serviceimpl;

import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
//查询所有的文章章节
    public List<Chapter> findAll() {
        List<Chapter> chapters = chapterDAO.queryAll();
        return chapters;
    }
//添加章节
    @Override
    public void addChapter(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapter.setUploadDate(new Date());
        chapterDAO.insert(chapter);
    }
}
