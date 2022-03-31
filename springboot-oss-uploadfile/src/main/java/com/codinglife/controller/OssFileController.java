package com.codinglife.controller;

import com.codinglife.service.OssFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CodingLife
 * @Description c
 * @since 2022/3/16 10:01
 */
@RestController
@RequestMapping("/oss/file")
public class OssFileController {

    @Autowired
    private OssFileService fileService;

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String uploadUrl = fileService.upload(file);
        return uploadUrl;
    }
}

