package com.leo.modules.module.upload;

import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.UploadFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author qingweiqu
 */
@Slf4j
@RestController
@RequestMapping(value = "/upload")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping(value = "/record")
    public ApiResult uploadRecord(MultipartFile file) {
        return null;
    }
}
