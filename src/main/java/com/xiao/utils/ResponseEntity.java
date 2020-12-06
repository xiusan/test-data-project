package com.xiao.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装服务端返回数据格式
 * @author yadonghe
 * @date 2020-03-17 15:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity {
    public static final Integer SUCCESS_CODE = 20000;
    public static final Integer ERROR_CODE = 300;
    /**
     * 请求响应码：成功/失败
     */
    private Integer code;
    /**
     * 提示语句
     * 成功。失败原因
     */
    private String message;
    /**
     * 封装查询结果
     */
    private Object data;

    public static ResponseEntity success(Object obj) {
        return new ResponseEntity(SUCCESS_CODE, "成功", obj);
    }

    public static ResponseEntity success() {
        return new ResponseEntity(SUCCESS_CODE, "成功", null);
    }

    public static ResponseEntity error() {
        return new ResponseEntity(ERROR_CODE, "失败", null);
    }

    public static ResponseEntity error(String message) {
        return new ResponseEntity(ERROR_CODE, message, null);
    }





}
