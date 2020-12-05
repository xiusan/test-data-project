package com.xiao.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xjl
 * @since 2020-12-04
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;


    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", name=" + name +
        "}";
    }
}
