package com.example.carecat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.carecat.dto.FeedDto;
import com.example.carecat.entity.Feed;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 200111124
 * @since 2022-12-09
 */
public interface FeedService extends IService<Feed> {
    /**
     * 分页查询
     * @param pageSize
     * @param page
     * @return
     */
    Page<FeedDto> selectPage(int pageSize,int page);

}
