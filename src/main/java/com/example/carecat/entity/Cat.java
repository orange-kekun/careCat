package com.example.carecat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Cat implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private String disposition;

    private String hobby;

    private String description;

    private String image;

    private String catName;

    private String con;

    private String category;


}
