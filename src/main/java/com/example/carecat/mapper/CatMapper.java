package com.example.carecat.mapper;

import com.example.carecat.entity.Cat;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 200111124
 * @since 2022-12-09
 */
@Mapper
public interface CatMapper extends BaseMapper<Cat> {

}
