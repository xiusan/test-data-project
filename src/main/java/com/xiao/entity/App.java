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
public class App extends Model<App> {

    private static final long serialVersionUID = 1L;

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

    public App setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public App setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "App{" +
        "id=" + id +
        ", name=" + name +
        "}";
    }
}
