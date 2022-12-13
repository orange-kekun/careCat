package com.example.carecat.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.carecat.common.R;
import com.example.carecat.dto.CatDto;
import com.example.carecat.dto.FeedDto;
import com.example.carecat.entity.Feed;
import com.example.carecat.service.FeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 200111124
 * @since 2022-12-09
 */
@RestController
@Slf4j
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private FeedService feedService;
    /**
     * 分页查询
     * @param pageSize
     * @param page
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int pageSize, int page){
        Page<FeedDto> pageRes = feedService.selectPage(pageSize,page);
        return R.success(pageRes);
    }

    /**
     * 添加投喂记录
     */
    @PostMapping
    public  R<String> add(@RequestBody Feed feed){
        feedService.save(feed);
        return R.success("添加成功");
    }

}

