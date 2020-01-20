package com.wanjy.backSystem.controller;

import cn.hutool.http.HttpRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.backSystem.Service.MyBackMenuService;
import com.wanjy.common.entity.ActiveUser;
import com.wanjy.common.entity.BackMenu;
import com.wanjy.common.service.BackMenuService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping("backmenu")
public class MyBackMenuController {
    @Autowired private MyBackMenuService myBackMenuService;
    @Autowired private BackMenuService backMenuService;

    /**
     * 查询全部菜单
     * @return
     */
    @RequestMapping("/getAllBackMenu")
    public Result getAllBackMenu(String name){
        return myBackMenuService.getAllBackMenu(name);
    }

    /**
     * 查询全部菜单
     * @return
     */
    @RequestMapping("/getAllBackMenuPage")
    public Result getAllBackMenu(int page, int limit, String name){
        IPage<BackMenu> backMenuIPage = myBackMenuService.getAllBackMenu(page,limit,name);
        return Result.success(backMenuIPage.getRecords(),(int)backMenuIPage.getTotal());
    }

    /**
     * 查询角色全部菜单
     * @return
     */
    @RequestMapping("/getAllRoleBackMenu")
    public Map getAllRoleBackMenu(HttpServletRequest request){
        ActiveUser activeUser =(ActiveUser) request.getSession().getAttribute("activeUser");
        return myBackMenuService.getAllRoleBackMenu(activeUser.getRole());
    }

    /**
     * 根据id删除菜单
     * @param id
     * @return
     */
    @RequestMapping("/deleteBackMenu")
    public Result deleteBackMenu(String id){
        Boolean n = backMenuService.removeById(id);
        if(n) return Result.success("删除成功");
        else return Result.error("删除失败");
    }

    /**
     * 根据role实体更新或保存菜单
     * roleId有则更新，没有则新增
     * @param backMenu
     * @return
     */
    @RequestMapping("/saveOrUpdateBackMenu")
    public Result saveOrUpdateBackMenu(BackMenu backMenu){
        if(backMenu.getMenuId()!=null && !backMenu.getMenuId().equals(""))
            backMenu.setUpdateTime(new Date());
        else backMenu.setCreateTime(new Date());
        Boolean n = backMenuService.saveOrUpdate(backMenu);
        if(n) return Result.success("保存成功");
        else return Result.error("保存失败");
    }
}
