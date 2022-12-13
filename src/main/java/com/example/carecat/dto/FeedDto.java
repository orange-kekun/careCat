package com.example.carecat.dto;

import com.example.carecat.entity.Feed;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
public class FeedDto  extends Feed implements Serializable {
    private String feedRecord;
}
