package com.baizhi.util;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;
import java.math.BigDecimal;

public class FileUtil {
    //音频时长 返回  **分**秒
    public static String LoadMP3Duration(File file) throws Exception {
        double t = 0;	
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
    //返回 文件大小  *.**MB
    public static String LoadMP3Size(File file){
        double length = file.length();
        double size = length/1024/1024;
        BigDecimal b = new BigDecimal(size);
        double value = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return value+"MB";
    }
	/*https://blog.csdn.net/tiantiandjava/article/details/9838397
	<!-- MP3音频处理相关jar包 -->
<dependency>
    <groupId>org</groupId>
    <artifactId>jaudiotagger</artifactId>
    <version>2.0.1</version>
</dependency>*/
	
}
