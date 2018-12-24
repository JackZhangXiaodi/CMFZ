package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.util.Row;
import com.baizhi.util.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    ViewObject viewObject = new ViewObject();
    @Autowired
    private AlbumService albumService;
    //展示所有的专辑
    @RequestMapping("/findAll")
    @ResponseBody
    public Row findAll(Integer page,Integer rows){
        Row row = new Row();
        Integer firstPage = (page-1)*rows+1;//起始条数
        Integer endPage=(page)*rows;//当前结束条数
        List<Album> all = albumService.findAllByPage(firstPage,endPage);
        Long couts = albumService.findCouts();
        int i = couts.intValue();
        row.setTotal(i);
        row.setRows(all);
        return row;
    }
//根据Id查询所选中专辑的信息
    @RequestMapping("/findOne")
    @ResponseBody
    public List<Album> findOne(String id){
        List<Album> one = albumService.findOne(id);
        return one;
    }
    @RequestMapping("/add")
    @ResponseBody
    //添加专辑的信息
    public void insert(Album album, MultipartFile aa, HttpServletRequest request) throws IOException {
            System.out.println(album);
            String realPath = request.getSession().getServletContext().getRealPath("/cmfz_jsp/albumAndchapter/pictures");
            String filename = aa.getOriginalFilename();
            aa.transferTo(new File(realPath,filename));
            album.setAlbumPicture("pictures/"+filename);
            albumService.addAlbum(album);
    }
    @RequestMapping("/delete")
    @ResponseBody
    //删除专辑的信息
    public ViewObject delete(String albumId){
        try {
            albumService.removeAlbum(albumId);
            viewObject.setSuccess(true);
            viewObject.setMessage("DELETE SUCCESS");
        }catch (Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }
}
