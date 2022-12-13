package com.example.carecat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.carecat.common.R;
import com.example.carecat.dto.CatDto;
import com.example.carecat.entity.Cat;
import com.example.carecat.mapper.CatMapper;
import com.example.carecat.service.CatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 200111124
 * @since 2022-12-09
 */
@Service
public class CatServiceImpl extends ServiceImpl<CatMapper, Cat> implements CatService {

    @Override
    public Page<CatDto> pageSelect(int pageSize, int page, String catName) {
        Page<Cat> pageInfo  =new Page<>(page,pageSize);
        Page<CatDto> pageDto  =new Page<>(page,pageSize);
        LambdaQueryWrapper<Cat> lqw = new LambdaQueryWrapper<>();
        lqw.like(catName!=null,Cat::getCatName,catName);
        this.page(pageInfo,lqw);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo,pageDto,"records");
        List<Cat> records = pageInfo.getRecords();
        List<CatDto> cats =records.stream().map((item)->{
            CatDto catDto = new CatDto();
            BeanUtils.copyProperties(item,catDto);
            catDto.setTrait(catDto.getDisposition()+"，喜欢"+catDto.getHobby());
            return catDto;
        }).toList();
        pageDto.setRecords(cats);
        return pageDto;

    }
}
