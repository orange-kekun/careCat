package com.example.carecat.dto;

import com.example.carecat.entity.Record;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
public class RecordDto extends Record implements Serializable {

    /**
     * 打卡用户
     */
    private String username;

}
