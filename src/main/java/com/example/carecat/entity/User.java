package com.example.carecat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private String phone;

    private String password;

    private String sex;
    @TableField("username")
    private String username;

    private String isVip;

    private String status;


}
