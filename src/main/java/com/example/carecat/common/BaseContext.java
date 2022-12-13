package com.example.carecat.common;

import lombok.extern.slf4j.Slf4j;

/**
 * 基于ThreadLocal封装的工具类，用户获取当前登录用户id
 * @author 200111124
 */
@Slf4j
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    /**
     * 设置值
     * @param id
     */
    public static  void setCurrentId(Long id){

        threadLocal.set(id);
    }

    /**
     * 获取值
     * @return
     */
    public static Long getCurrentId(){
        log.info("id+{}",threadLocal.get());

        return threadLocal.get();
    }
}
