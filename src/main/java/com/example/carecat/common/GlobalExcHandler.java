package com.example.carecat.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常捕获处理类
 * @author 200111124
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExcHandler {
    /**
     * sql异常处理方法
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> sqlExceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());

        //对于数据库报重复异常
        if(ex.getMessage().contains("Duplicate entry")){
            String[] s = ex.getMessage().split(" ");
            String msg =s[2]+"已经存在";
            return R.error(msg);
        }else{
            return  R.error("未知异常");
        }
    }

    /**
     * 自定义异常的处理方法
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public R<String> myExceptionHandler(CustomException ex){
        log.info(ex.getMessage());
        return  R.error(ex.getMessage());
    }

}
