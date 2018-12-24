package com.baizhi.test;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
public class AlbumTest {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumDAO albumDAO;
    @Autowired
    private ChapterService chapterService;
    @Test
    public void test(){
        Album album = new Album();
        album.setId(UUID.randomUUID().toString());
        album.setAlbumAuthor("jack");
        album.setAlbumVoice("zhang");
        album.setAlbumPicture("/user/ss");
        album.setContent("惺惺惜惺惺");
        album.setCreatedate(new Date());
        album.setSeason("32");
        album.setName("xiao");
        albumService.addAlbum(album);
    }
  /*  @Test
    public void test2(){
        List<Album> all = albumService.findAll();
        for (Album album : all) {
            System.out.println(album);
        }
    }*/
    @Test
    public void test3(){
        albumService.removeAlbum("267f3c5c-a9e9-494a-a5fc-6a2af2ed82a9");
    }
    @Test
    public void test4(){
        Chapter chapter = new Chapter();
        chapter.setName("asd");
        chapter.setDuration("12");
        chapter.setAlbumName("七里香");
        chapter.setChapSize(2.0);
        chapter.setChapUrl("asdasd");
        chapter.setUploadDate(new Date());
        chapter.setId("7");
        chapterService.addChapter(chapter);
    }
    @Test
    public void test5(){
        Long aLong = albumDAO.queryTotalCounts();
        System.out.println(aLong);
    }
    @Test
    public void test6(){
        List<Album> albums = albumService.findAllByPage(0, 11);
        for (Album album : albums) {
            System.out.println(album);
        }
    }
    @Test
    public void test7(){
        List<Album> one1 = albumService.findOne("1");
        System.out.println(one1);
    }
}
