package com.xiao.service.impl;

import com.xiao.entity.App;
import com.xiao.mapper.AppMapper;
import com.xiao.service.IAppService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xjl
 * @since 2020-12-04
 */
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App> implements IAppService {

}
