package com.xiao.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiao.entity.User;
import com.xiao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2020/12/4.
 */
@RestController
public class TestMysql {
    @Autowired
    private UserMapper mapper;

    @RequestMapping("test")
    public void test() {
        Page<User> mpPage = mapper.selectPage(new Page<>(1, 2), Wrappers.<User>query().eq("id", 1));

        List<User> records = mpPage.getRecords();
        for (User user:records) {
            System.out.println(user.getId());

        }

        // pagehelper
        PageInfo<User> info = PageHelper.startPage(1, 2).doSelectPageInfo(() -> mapper.selectById(1));

        List<User> list = info.getList();

    }
}
