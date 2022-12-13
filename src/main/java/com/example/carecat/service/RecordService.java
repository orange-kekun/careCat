package com.example.carecat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.carecat.dto.RecordDto;
import com.example.carecat.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 200111124
 * @since 2022-12-09
 */
public interface RecordService extends IService<Record> {

    Page<RecordDto> pageSelect(int pageSize, int page);
}
