package com.xiao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author miemie
 * @since 2020-05-29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
