package com.example.carecat.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回消息类
 * @author 200111124
 */

@Data
public class R<T> {
    /**
     * 编码：1成功，0和其他为失败
     */
    private  Integer code;
    /**
     *    错误信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;
    /**
     * 动态数据
     */
    private Map<String,Object> map=new HashMap<>();

    /**
     * 成功
     * @param object 对象
     * @param <T> 类型
     * @return 信息
     */
    public static <T> R<T> success(T object){
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return  r;
    }

    /**
     * 失败
     * @param str 错误内容
     * @param <T> 类型
     * @return 信息
     */
    public static <T> R<T> error(String str){
        R r = new R();
        r.msg = str;
        r.code = 0;
        return  r;
    }

    public R<T> add(String key, Object value){
        this.map.put(key,value);
        return this;
    }

}
