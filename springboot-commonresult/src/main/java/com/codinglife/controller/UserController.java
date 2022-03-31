package com.codinglife.controller;


import com.codinglife.api.CommonResult;
import com.codinglife.entity.User;
import com.codinglife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("listAll")
    public CommonResult list(){
        List<User> list = userService.list(null);
        return CommonResult.success().data("items", list);
    }

    @DeleteMapping("delete/{id}")
    public CommonResult deleteTeacherById(@PathVariable String id) {

        boolean result =  userService.removeById(id);
        if (result) {
            return CommonResult.success();
        } else {
            return CommonResult.error();
        }
    }

    @PostMapping("addUser")
    public CommonResult addUser(@Valid @RequestBody User user) {
        boolean result = userService.save(user);
        if (result) {
            return CommonResult.success();
        } else
            return CommonResult.error();
    }

}
