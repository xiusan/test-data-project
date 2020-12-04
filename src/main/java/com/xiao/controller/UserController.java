package com.xiao.controller;


import com.xiao.BaseController;
import com.xiao.entity.User;
import com.xiao.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xjl
 * @since 2020-12-04
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @GetMapping("/allUser")
    public Object allStudent(){
        User byId = userServiceImpl.getById("1");
        return byId;

    }


}

