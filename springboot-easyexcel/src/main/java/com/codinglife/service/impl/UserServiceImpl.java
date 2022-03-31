package com.codinglife.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codinglife.entity.User;
import com.codinglife.listener.UserExcelListener;
import com.codinglife.mapper.UserMapper;
import com.codinglife.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author CodingLife
 * @Description TODD
 * @since 2022/3/21 11:06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public void batchImportUser(MultipartFile file, UserService userService) {
        try {
            InputStream is = file.getInputStream();
            // read(InputStream inputStream, Class head, ReadListener readListener)
            // inputStream 输入流; head 需要导入excel表对应的实体类; readListener 事件监听器,用来监听处理读取到的每一条数据,读取excel表第一个sheet
            EasyExcel.read(is, User.class, new UserExcelListener(userService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
