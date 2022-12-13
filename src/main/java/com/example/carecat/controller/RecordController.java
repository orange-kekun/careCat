package com.example.carecat.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.carecat.common.R;
import com.example.carecat.dto.RecordDto;
import com.example.carecat.entity.Record;
import com.example.carecat.entity.User;
import com.example.carecat.service.RecordService;
import com.example.carecat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;


    /**
     * 分页查询
     * @param pageSize
     * @param page
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int pageSize, int page){
        Page<RecordDto> pageRes = recordService.pageSelect(pageSize,page);
        return R.success(pageRes);
    }

    /**
     * 新增猫猫信息
     * @param record
     * @return
     */
    @PostMapping
    public R<String> updateOrAdd(@RequestBody Record record){
        log.info("{}",record);
        recordService.saveOrUpdate(record);
        return R.success("打卡成功");
    }

}

