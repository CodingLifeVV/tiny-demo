package com.codinglife.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codinglife.entity.User;
import com.codinglife.mapper.UserMapper;
import com.codinglife.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author CodingLife
 * @Description TODD
 * @since 2022/3/4 20:17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
