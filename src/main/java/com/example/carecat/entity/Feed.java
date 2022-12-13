package com.example.carecat.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author 200111124
 * @since 2022-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Feed implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    @TableField(fill = FieldFill.INSERT)
    private Long userId;

    private String foodName;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private Long catId;


}
