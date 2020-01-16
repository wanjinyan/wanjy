package com.wanjy.backSystem.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wanjy.backSystem.Service.MyBackMenuService;
import com.wanjy.common.entity.BackMenu;
import com.wanjy.common.service.BackMenuService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyBackMenuServiceImpl implements MyBackMenuService {
    @Autowired
    private BackMenuService backMenuService;
    @Override
    public Result getAllBackMenu(String name) {
        {
            List<BackMenu> backMenuList = new ArrayList<>();
            if(name!=null && name.equals("")){
                QueryWrapper<BackMenu> backMenuQueryWrapper = new QueryWrapper<>();
                backMenuQueryWrapper.like("menu_name",name);
                backMenuList=backMenuService.list(backMenuQueryWrapper);
            }else {
                backMenuList=backMenuService.list();
            }
            if(backMenuList!=null && backMenuList.size()>0) return Result.success(backMenuList,backMenuList.size());
            else return Result.error("查询菜单失败");
        }
    }
}
