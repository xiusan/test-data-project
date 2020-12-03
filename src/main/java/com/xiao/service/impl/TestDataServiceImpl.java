package com.xiao.service.impl;

import com.google.common.collect.Lists;
import com.xiao.entity.Student;
import com.xiao.service.TestDataService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xioajinlu1990@163.com on 2020/12/3.
 */
@Service("testDataServiceImpl")
public class TestDataServiceImpl implements TestDataService {
    @Override
    public List<Student> getAllStudent() {
        List<Student> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAge(10+i);
            student.setClassName("三年级："+(1+i)+"班级");
            student.setName("小"+(1+i)+"花");
            list.add(student);
        }
        return list;
    }
}
