package com.wanjy.backSystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.common.entity.Menu;
import com.wanjy.common.service.MenuService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 12068
 * @date 2020/2/16  15:27
 */
@RestController
@RequestMapping("/menu")
public class MyMenuController {
    @Autowired MenuService menuService;

    /**
     * 调用服务层接口保存前端传过来的内容
     * @param menu
     * @return
     */
    @PostMapping("/addMenu")
    public Result addMenu(Menu menu){
        boolean b = menuService.save(menu);
        return Result.isSuccess(b,"添加");
    }

    /**
     * 根据前端传过来的menId删除
     * @param menuId
     * @return
     */
    @DeleteMapping("/deleteMenu")
    public Result deleteMenu(String menuId){
        boolean b = menuService.removeById(menuId);
        return Result.isSuccess(b,"删除");
    }

    /**
     * 根据前端传过来的menu的menuId来保存，即是修改
     * @param menu
     * @return
     */
    @PostMapping("/updateMenu")
    public Result updateMenu(Menu menu){
        boolean b = menuService.updateById(menu);
        return Result.isSuccess(b,"修改");
    }

    @PostMapping("/saveOrUpdateMenu")
    public Result saveOrUpdateMenu(Menu menu){
        boolean b = menuService.saveOrUpdate(menu);
        return Result.isSuccess(b,"保存或更新");
    }

    /**
     * 采用分页查询
     * 先根据菜单名字查询，如果名字不为空，构造条件查询器，调用服务层接口做模糊查询
     * 否则，查询全部
     * @param page
     * @param limit
     * @param menuName
     * @return
     */
    @GetMapping("/getMenu")
    public Result getMenu(int page, int limit, String menuName){
        IPage<Menu> menuIPage = new Page<>(page,limit);
        if(menuName != null && !menuName.equals("")){
            QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
            menuQueryWrapper.like("menu_name",menuName);
            menuIPage = menuService.page(menuIPage,menuQueryWrapper);
        }else {
            menuIPage = menuService.page(menuIPage);
        }
        return Result.success(menuIPage.getRecords(),(int)menuIPage.getTotal());
    }

    /**
     * 查询展示的菜单
     * @return
     */
    @GetMapping("/getShowMenu")
    public Result getShowMenu(){
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.like("menu_status",1);
        List<Menu> menuList = menuService.list(menuQueryWrapper);
        return Result.success(menuList,menuList.size());
    }
}
