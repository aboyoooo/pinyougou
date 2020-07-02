package com.hlkj.filesoperator.service;

import com.hlkj.common.utils.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    Result upload(MultipartFile file);

}
