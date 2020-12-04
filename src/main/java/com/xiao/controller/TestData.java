package com.xiao.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiao.entity.User;
import com.xiao.mapper.UserMapper;
import com.xiao.service.impl.TestDataServiceImpl;
import com.xiao.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xioajinlu1990@163.com on 2020/12/3.
 */
@RestController
@RequestMapping("/api")
public class TestData {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private TestDataServiceImpl testDataService;


    @PostMapping("/allStudent")
    public Object allStudent(){
        return testDataService.getAllStudent();

    }
    @GetMapping("/getAllStudent")
    public Object getAllStudent(){
        return testDataService.getAllStudent();

    }

    @RequestMapping("test")
    public ResponseEntity test() {
        Page<User> mpPage = mapper.selectPage(new Page<>(1, 2), Wrappers.<User>query().eq("id", 1));

        List<User> records = mpPage.getRecords();
        for (User user:records) {
            System.out.println(user.getId());

        }

        // pagehelper
       // PageInfo<User> info = PageHelper.startPage(1, 2).doSelectPageInfo(() -> mapper.selectById(1));
        PageInfo<User> info = PageHelper.startPage(1, 2).doSelectPageInfo(() -> mapper.selectById(1));

        List<User> list = info.getList();

        return ResponseEntity.success(info);
    }

}
