package com.example.carecat.dto;

import com.example.carecat.entity.Cat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 猫猫扩展类
 * @author 200111124
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class CatDto extends Cat implements Serializable {

    /**
     * 综合特点
     */
    private String trait;
}
