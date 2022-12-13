package com.example.carecat.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.carecat.common.R;
import com.example.carecat.dto.CatDto;
import com.example.carecat.entity.Cat;
import com.example.carecat.service.CatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequestMapping("/cat")
public class CatController {

    @Autowired
    CatService catService;

    /**
     * 分页查询
     * @param pageSize
     * @param page
     * @param catName
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int pageSize, int page, String catName){
        Page<CatDto> pageRes = catService.pageSelect(pageSize,page,catName);
        return R.success(pageRes);
    }

    /**
     *获取所有猫猫
     */
    @GetMapping("/list")
    public R<List<Cat>> getList(){
        return R.success(catService.list());
    }


    /**
     * 根据id回显页面
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<CatDto> get(@PathVariable Long id){
        Cat cat = catService.getById(id);
        CatDto catDto = new CatDto();
        BeanUtils.copyProperties(cat,catDto);
        catDto.setTrait(catDto.getDisposition()+"，喜欢"+catDto.getHobby());
        return R.success(catDto);
    }

    /**
     * 新增猫猫信息
     * @param cat
     * @return
     */
    @PostMapping
    public R<String> updateOrAdd(@RequestBody Cat cat){
        catService.saveOrUpdate(cat);
        return R.success("新猫猫添加成功");
    }

    /**
     * 修改猫猫信息
     * @param cat
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Cat cat){
        catService.updateById(cat);
        return R.success("修改成功");
    }



    /**
     * 删除猫猫
     * @param ids
     * @return
     */
    @DeleteMapping()
    public R<String> delete(@RequestParam List<Long> ids){
        catService.removeBatchByIds(ids);
        return R.success("删除成功");
    }

}

