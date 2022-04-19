package com.codinglife.controller;

import com.codinglife.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 视频点播Controller
 * @author: CodingLifeVV
 * @date: 2022.04.12
 */
@RestController
@RequestMapping("/video")
public class VodController {
    @Autowired
    private VodService vodService;

    @PostMapping("uploadVideo")
    public String uploadVideo(MultipartFile file) {
        String videoId = vodService.uploadVideo(file);
        return "视频上传成果，videoId" + videoId;
    }
}
