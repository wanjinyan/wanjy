package com.wanjy.backSystem.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.backSystem.Service.MyBackMenuService;
import com.wanjy.backSystem.entity.MyBackMenu;
import com.wanjy.common.entity.BackMenu;
import com.wanjy.common.service.BackMenuService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyBackMenuServiceImpl implements MyBackMenuService {
    @Autowired
    private BackMenuService backMenuService;
    @Override
    public Result getAllBackMenu(String name) {
        {
            List<BackMenu> backMenuList = new ArrayList<>();
            QueryWrapper<BackMenu> backMenuQueryWrapper = new QueryWrapper<>();
            backMenuQueryWrapper.orderByAsc("order_number");
            if(name!=null && name.equals("")){
                backMenuQueryWrapper.like("title",name);
            }
            backMenuList=backMenuService.list(backMenuQueryWrapper);
            if(backMenuList!=null && backMenuList.size()>0) return Result.success(backMenuList,backMenuList.size());
            else return Result.error("查询菜单失败");
        }
    }

    @Override
    public IPage<BackMenu> getAllBackMenu(int page, int limit, String name) {
        IPage<BackMenu> iPage = new Page<>(page,limit);
        if( name != null && !name.equals("")){
            QueryWrapper<BackMenu> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("title",name);
            iPage = backMenuService.page(iPage,queryWrapper);
        }else {
            iPage = backMenuService.page(iPage);
        }
        return iPage;
    }

    @Override
    public Map getAllRoleBackMenu(String role) {
        Map map =new HashMap();
        map.put("clearInfo",getclearInfo());
        map.put("homeInfo",gethomeInfo(role));
        map.put("logoInfo",getlogoInfo());
        map.put("menuInfo",getmenuInfo(role));
        return map;
    }

    public BackMenu getclearInfo(){
        BackMenu backMenu = backMenuService.getById("4");
        return backMenu;
    }
    public BackMenu gethomeInfo(String role){
        BackMenu backMenu=null;
        if(role.equals("admin:shop")){
            backMenu = backMenuService.getById("15");
        }else {
            backMenu = backMenuService.getById("0");
        }

        return backMenu;
    }
    public BackMenu getlogoInfo(){
        BackMenu backMenu = backMenuService.getById("1");
        return backMenu;
    }
    public Map getmenuInfo(String role){
        Map map = new HashMap();
        map.put("currency",getAllMenu(role));
        return map;
    }

    public MyBackMenu getAllMenu(String role){
        BackMenu backMenu = backMenuService.getById("2");
        MyBackMenu myBackMenu = new MyBackMenu();
        myBackMenu.setTitle(backMenu.getTitle());
        myBackMenu.setHref(backMenu.getHref());
        myBackMenu.setParentId(backMenu.getMenuId());
        myBackMenu.setTarget(backMenu.getTarget());
        myBackMenu.setIcon(backMenu.getIcon());
        myBackMenu.setChild(getMenuByParentId(myBackMenu.getParentId(),role));
        return myBackMenu;
    }

    public List<MyBackMenu> getMenuByParentId(String parentId,String role){
        QueryWrapper<BackMenu> queryWrapper=new QueryWrapper<>();
        List<String> authoritys=new ArrayList<>();
        authoritys.add("");
        authoritys.add(role);
        authoritys.add(null);
        queryWrapper
                .eq("parent_id",parentId);
        queryWrapper
                .in("authority",authoritys)
                .orderByAsc("order_number");
        List<BackMenu> backMenus = backMenuService.list(queryWrapper);
        List<MyBackMenu> myBackMenus = new ArrayList<>();
        for(BackMenu backMenu:backMenus){
            MyBackMenu myBackMenu = new MyBackMenu();
            myBackMenu.setTitle(backMenu.getTitle());
            myBackMenu.setHref(backMenu.getHref());
            myBackMenu.setParentId(backMenu.getMenuId());
            myBackMenu.setTarget(backMenu.getTarget());
            myBackMenu.setIcon(backMenu.getIcon());
            List<MyBackMenu> list = getMenuByParentId(backMenu.getMenuId(),role);
            if(list.size()>0)
                myBackMenu.setChild(list);
            myBackMenus.add(myBackMenu);
        }
        return myBackMenus;
    }

}
