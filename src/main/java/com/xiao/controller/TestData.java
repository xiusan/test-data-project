package com.xiao.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xiao.entity.User;
import com.xiao.mapper.UserMapper;
import com.xiao.service.impl.TestDataServiceImpl;
import com.xiao.service.impl.UserServiceImpl;
import com.xiao.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 总数据返回
 * Created by xioajinlu1990@163.com on 2020/12/3.
 */
@RestController
@RequestMapping("/api")
public class TestData {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserServiceImpl userServiceImpl;

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

    /**
     * 测试分页实现
     * @param page 当前页 默认1
     * @param limit 最大查询条数 默认10
     * @return
     */
    @RequestMapping("/test")
    public ResponseEntity test(@RequestParam(defaultValue="1") Integer page,
                               @RequestParam(defaultValue="10") Integer limit) {
        Page<User> mpPage = userServiceImpl.page(new Page<>(page, limit), Wrappers.<User>query());

        List<User> records = mpPage.getRecords();
        for (User user:records) {
            System.out.println(user.getId());

        }

        return ResponseEntity.success(mpPage);
    }

    /**
     * 简单分页实现
     * @param page 当前页 默认1
     * @param limit 最大查询条数 默认10
     * @return
     */
    @GetMapping("/getAllUserSimple")
    public ResponseEntity getAllUserSimple(@RequestParam(defaultValue="1") Integer page,
                                     @RequestParam(defaultValue="10") Integer limit) {
        List<User> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(new User(Long.parseLong(String.valueOf(i)),i+"分子"));
            System.out.printf("VALUES ("+i+", 'Jone"+i+"'),");

        }
        return ResponseEntity.success(list);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(" ("+i+", 'Jone"+i+"'),");

        }
    }

    /**
     * 简单分页实现
     * @param page 当前页 默认1
     * @param limit 最大查询条数 默认10
     * @return
     */
    @GetMapping("/getAllUser")
    public ResponseEntity getAllUser(@RequestParam(defaultValue="1") Integer page,
                                     @RequestParam(defaultValue="10") Integer limit,
                                     @RequestParam(value = "name", required = false)  String name,
                                     @RequestParam(value = "address", required = false)   String address) {
        User user = new User();

        if (!"".equals(name) && null != name){
            user.setName(name);
        }

        Page<User> mpPage = userServiceImpl.page(new Page<>(page, limit), Wrappers.query(user));
        return ResponseEntity.success(mpPage);
    }


    /**
     * 添加用户
     * @return
     */
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user) {
//        if (!"".equals(user.getName()) && null != user.getName()){
//            user.setName(name);
//        }

        boolean update = userServiceImpl.saveOrUpdate(user);
        return ResponseEntity.success(update);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        userServiceImpl.remove(Wrappers.<User>query().in("id", id));
        return ResponseEntity.success();
    }

}
