package com.example.carecat.controller;

import com.example.carecat.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传和下载
 * @author 200111124
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {
    /**
     * 文件路径
     */
    @Value("${catcare.path}")
    private String basePath;
    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        log.info(file.toString());
        //文件原名
        String originalFileName =file.getOriginalFilename();

        //UUID生成文件名防止重复
        assert originalFileName != null;
        String suffix =  originalFileName.substring(originalFileName.lastIndexOf('.'));
        String fileName = UUID.randomUUID().toString()+suffix;

        File dir =  new File(basePath);
        if(!dir.exists()){
            //目录不存在，创建
            if(!dir.mkdirs()){
                return R.error("文件上传失败");
            }
        }
        try{
            file.transferTo(new File(basePath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(fileName);
    }

    /**
     * 文件下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        try {
            //输入流，读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
            //输出流，通过输出流将文件写回浏览器
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while((len =fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            outputStream.close();
            fileInputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
