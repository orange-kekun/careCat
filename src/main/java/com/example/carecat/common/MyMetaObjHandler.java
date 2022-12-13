package com.example.carecat.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 元数据对象处理器
 * @author 200111124
 */
@Component
@Slf4j
public class MyMetaObjHandler implements MetaObjectHandler {
    private  final Long DEFAULTUSER = 1L;

    /**
     * 插入字段自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("自动填充开启");
        metaObject.setValue("createTime", LocalDateTime.now());
        Long currentId = BaseContext.getCurrentId();
        log.info("当前id{}",currentId);
        metaObject.setValue("userId", Objects.requireNonNullElse(currentId, DEFAULTUSER));

    }

    /**
     * 更新自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("自动填充开启");
        metaObject.setValue("createTime", LocalDateTime.now());
        Long currentId = BaseContext.getCurrentId();
        metaObject.setValue("userId", Objects.requireNonNullElse(currentId, DEFAULTUSER));
    }
}
