package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.ViewObject;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;


@Controller
@RequestMapping("/chapter")
public class ChapterController {
    ViewObject viewObject = new ViewObject();
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/findAll")
    @ResponseBody
   //查询所有的章节音频
    public List<Chapter> findAll(){
        List<Chapter> all = chapterService.findAll();
        return all;
    }
    //添加章节音频
    @RequestMapping("/add")
    @ResponseBody
    public ViewObject add(Chapter chapter, MultipartFile aa, HttpServletRequest request){
        try {
            if(aa.getContentType().equals("audio/mp3")){
                //获取绝对的路径
                String realPath = request.getSession().getServletContext().getRealPath("/cmfz_jsp/albumAndchapter/pictures");
                //获取文件原文件名字
                String filename = aa.getOriginalFilename();
                //获取文件的大小
                Double size = (double)aa.getSize();
                //文件上传
                File file = new File(realPath, filename);
                aa.transferTo(file);
                //获取音频时长
                String duration = getMp3TrackLength(file);
                chapter.setChapUrl("pictures/"+realPath);
                chapter.setChapSize(size);
                chapter.setDuration(duration);
                chapter.setName(filename);
                chapterService.addChapter(chapter);
                viewObject.setSuccess(true);
                viewObject.setMessage("ADD SUCCESS");
            }
        }catch (Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }
    public  String getMp3TrackLength(File file) throws Exception{
        double t=0;
        MP3File f = (MP3File) AudioFileIO.read(file);
        //获得时长
        MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
        t = audioHeader.getPreciseTrackLength()/60;
        //精度计算
        BigDecimal b = new BigDecimal(t);
        double value = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        String s = String.valueOf(value);
        String replace = s.replace(".", "分");
        return replace+"秒";
    }

    /*public static Long getDuration(File source){
        //格式编码
        Encoder encoder = new Encoder();
        long ls=0;
        MultimediaInfo m;
        try {
            m=encoder.getInfo(source);
            ls=m.getDuration()/1000;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }*/
//    章节的下载
    @RequestMapping("/uploadDown")
    @ResponseBody
    public ViewObject uploadDown(String name, HttpServletRequest request , HttpServletResponse response){
        try {
            //获取文件的绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("/cmfz_jsp/albumAndchapter/pictures");
            //根据文件获取指定文件的输入流
            FileInputStream is = new FileInputStream(new File(realPath + "/" + name));
            //设置响应头
            response.setHeader("content-disposition","attachment;name="+ URLEncoder.encode(name,"UTF-8"));
            //获取输出流
            ServletOutputStream os = response.getOutputStream();
            //拷贝
            IOUtils.copy(is,os);
            //关流
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }catch (Exception e){
            viewObject.setSuccess(false);
            viewObject.setMessage(e.getMessage());
        }
        return viewObject;
    }
}
