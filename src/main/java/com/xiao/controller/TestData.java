package com.xiao.controller;

import com.xiao.service.impl.TestDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xioajinlu1990@163.com on 2020/12/3.
 */
@RestController
@RequestMapping("/api")
public class TestData {

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

}
