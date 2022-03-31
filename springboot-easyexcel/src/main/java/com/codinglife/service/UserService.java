package com.codinglife.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codinglife.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService extends IService<User> {
    void batchImportUser(MultipartFile file, UserService userService);
}
