package com.codinglife.service;

import org.springframework.web.multipart.MultipartFile;

public interface VodService {
    String uploadVideo(MultipartFile file);
    void removeVideo(String videoId);
}
