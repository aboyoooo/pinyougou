package com.hlkj.filesoperator.service.impl;

import com.hlkj.common.utils.Result;
import com.hlkj.filesoperator.mapper.FileMapper;
import com.hlkj.filesoperator.service.FileService;
import com.hlkj.pojo.model.File;
import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FastFileStorageClient fastFileStorageClient;

    @Resource
    FileMapper fileMapper;

    @Override
    public Result upload(MultipartFile file) {
        //1.fastdfs：保存之后要返回path
        StorePath storePath=null;
        try {
            String filename = file.getOriginalFilename();
            String extend = FilenameUtils.getExtension(filename);
            //保存到fastdfs上
            storePath = fastFileStorageClient.uploadFile("group1", file.getBytes(), extend);
            //数据库中进行记录
            fileMapper.add(new File(filename,storePath.getGroup(),storePath.getFullPath()));

        }catch (Exception e){
            e.printStackTrace();
        }
        if(storePath!=null){
            return new Result(true,storePath.getFullPath());
        }else {
            return new Result(false,"保存失败！");
        }
    }
}
