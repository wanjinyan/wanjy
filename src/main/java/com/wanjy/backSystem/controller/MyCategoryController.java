package com.wanjy.backSystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.common.entity.Category;
import com.wanjy.common.service.CategoryService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 12068
 * @date 2020/2/16  14:24
 */
@RestController
@RequestMapping("/category")
public class MyCategoryController {
    @Autowired private CategoryService categoryService;

    /**
     * 思路：调用服务层接口保存前端传过来的实体内容
     * @param category
     * @return
     */
    @PostMapping("/addCategory")
    public Result addCategory(Category category){
        Boolean bool = categoryService.save(category);
        return Result.isSuccess(bool,"添加");
    }

    /**
     * 思路：根据categoryId判断删除，如果有这个类别，删除成功，否则，删除失败
     * @param categoryId
     * @return
     */
    @DeleteMapping("/deleteCategory")
    public Result deleteCategory(String categoryId){
        boolean b = categoryService.removeById(categoryId);
        return Result.isSuccess(b,"删除");
    }

    /**
     * 思路：根据前端穿过来的实体中的categoryId掉用服务层接口进行保存（更新）
     * @param category
     * @return
     */
    @PostMapping("/updateCategory")
    public Result updateCategory(Category category){
        boolean b = categoryService.updateById(category);
        return Result.isSuccess(b,"修改");
    }

    @PostMapping("/saveOrUpdateCategory")
    public Result saveOrUpdateCategory(Category category){
        boolean b = categoryService.saveOrUpdate(category);
        return Result.isSuccess(b,"保存");
    }

    /**
     * 思路：采用分页查询
     * 1、先根据名字查询，如果名字，构造条件查询器，调用服务层接口进行模糊查询，
     * 如果没有，就查询全部
     * 2、返回查询的结果和条数
     * @param page
     * @param limit
     * @param categoryName
     * @return
     */
    @GetMapping("/getCategory")
    public Result getCategory(int page, int limit, String categoryName){
        IPage<Category> categoryIPage = new Page<>(page,limit);
        if(categoryName != null && !categoryName.equals("")){
            QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
            categoryQueryWrapper.like("category_name", categoryName);
            categoryIPage = categoryService.page(categoryIPage,categoryQueryWrapper);
        }else {
            categoryIPage = categoryService.page(categoryIPage);
        }
        return Result.success(categoryIPage.getRecords(),(int)categoryIPage.getTotal());
    }
}
