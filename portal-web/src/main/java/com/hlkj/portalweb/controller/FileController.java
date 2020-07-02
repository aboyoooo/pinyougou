package com.hlkj.portalweb.controller;

import com.google.inject.internal.cglib.proxy.$Factory;
import com.hlkj.common.utils.Result;
import com.hlkj.portalweb.feign.FilesFeingClient;
import com.sun.org.apache.regexp.internal.RE;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    FilesFeingClient filesFeingClient;

    @PostMapping(value = "/upload")
    Result upload(MultipartFile file) throws IOException {
        System.out.println(file);
        Result ret=null;
        if(file==null){
            return new Result(false,"上传文件不能为空");
        }else {
            ret=filesFeingClient.upload(file);
            System.out.println(ret.getMessage());
            if(ret==null){
                return new Result(false,"上传到provider error");
            }else {
                return ret;
            }
            //return new Result(false,"上传成功！");
        }
    }

}
