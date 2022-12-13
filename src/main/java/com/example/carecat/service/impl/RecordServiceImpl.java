package com.example.carecat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.carecat.common.BaseContext;
import com.example.carecat.dto.CatDto;
import com.example.carecat.dto.RecordDto;
import com.example.carecat.entity.Cat;
import com.example.carecat.entity.Record;
import com.example.carecat.mapper.RecordMapper;
import com.example.carecat.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.carecat.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Autowired
    UserService userService;

    @Override
    public Page<RecordDto> pageSelect(int pageSize, int page) {
        Page<Record> pageInfo  =new Page<>(page,pageSize);
        Page<RecordDto> pageDto  =new Page<>(page,pageSize);
        LambdaQueryWrapper<Record> lqw = new LambdaQueryWrapper<>();
        this.page(pageInfo,lqw);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo,pageDto,"records");
        List<Record> records = pageInfo.getRecords();
        List<RecordDto> recordDtoList =records.stream().map((item)->{
            RecordDto recordDto = new RecordDto();
            BeanUtils.copyProperties(item,recordDto);
            if(recordDto.getUserId()!=null){
                String  username=userService.getById(recordDto.getUserId()).getUsername();
                recordDto.setUsername(username);
            }else{
                recordDto.setUsername("神秘人");
            }
            return recordDto;
        }).toList();
        pageDto.setRecords(recordDtoList);
        return pageDto;
    }
}
