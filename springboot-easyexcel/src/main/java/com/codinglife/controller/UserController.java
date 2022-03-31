package com.codinglife.controller;

import com.codinglife.service.UserService;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CodingLife
 * @Description TODD
 * @since 2022/3/20 22:20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("addSubject")
    public String addCourseSubject(@RequestParam("file") MultipartFile file) {
        StaticComponentContainer.Modules.exportAllToAll(); // 解决JDK17与easyexcel报错问题
        userService.batchImportUser(file, userService);
        return "OK";
    }
}
