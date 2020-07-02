package com.hlkj.filesoperator.controller;

import com.hlkj.common.utils.Result;
import com.hlkj.filesoperator.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/file/upload")
    public Result upload(@RequestPart(value = "file",required = false) MultipartFile file){
        Result ret=null;
        try{
            ret=fileService.upload(file);

        }catch (Exception e){
            e.printStackTrace();
            ret=new Result(true,"保存失败");
        }
        return ret;
    }
}
