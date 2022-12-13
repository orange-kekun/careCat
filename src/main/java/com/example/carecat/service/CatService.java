package com.example.carecat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.carecat.common.R;
import com.example.carecat.dto.CatDto;
import com.example.carecat.entity.Cat;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 200111124
 * @since 2022-12-09
 */
public interface CatService extends IService<Cat> {

    /**
     * 分页查询
     * @param pageSize
     * @param page
     * @param catName
     * @return
     */
    Page<CatDto> pageSelect(int pageSize, int page, String catName);
}
