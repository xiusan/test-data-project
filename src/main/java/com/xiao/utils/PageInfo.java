package com.xiao.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yadonghe
 * @date 2020-03-19 10:24
 * 分页对象
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageInfo<T> {
    /**
     * 总条数
     */
    private Long total;
    /**
     * 当前页数据
     */
    private List<T> data;

}
