package com.example.carecat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.carecat.dto.FeedDto;
import com.example.carecat.dto.FeedDto;
import com.example.carecat.entity.Cat;
import com.example.carecat.entity.Feed;
import com.example.carecat.mapper.FeedMapper;
import com.example.carecat.service.CatService;
import com.example.carecat.service.FeedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.carecat.service.UserService;
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
public class FeedServiceImpl extends ServiceImpl<FeedMapper, Feed> implements FeedService {
    @Autowired
    private UserService userService;
    @Autowired
    private CatService catService;

    @Override
    public Page<FeedDto> selectPage(int pageSize, int page) {
        Page<Feed> pageInfo  =new Page<>(page,pageSize);
        Page<FeedDto> pageDto  =new Page<>(page,pageSize);
        LambdaQueryWrapper<Feed> lqw = new LambdaQueryWrapper<>();
        this.page(pageInfo,lqw);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo,pageDto,"records");
        List<Feed> records = pageInfo.getRecords();
        List<FeedDto> feeds =records.stream().map((item)->{
            FeedDto feedDto = new FeedDto();
            BeanUtils.copyProperties(item,feedDto);
            String username = userService.getById(feedDto.getUserId()).getUsername();
            String catname = catService.getById(feedDto.getCatId()).getCatName();
            feedDto.setFeedRecord(username+"给"+catname+"投喂了"+ feedDto.getFoodName());
            return feedDto;
        }).toList();
        pageDto.setRecords(feeds);
        return pageDto;

    }
}
