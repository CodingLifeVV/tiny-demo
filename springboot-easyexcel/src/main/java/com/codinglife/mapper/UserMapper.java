package com.codinglife.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codinglife.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author CodingLife
 * @Description TODD
 * @since 2022/3/21 11:09
 */
@Mapper
public interface UserMapper extends BaseMapper<User>  {
}
