package com.wanjy.backSystem.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.backSystem.Service.MyPermissionService;
import com.wanjy.common.entity.Permission;
import com.wanjy.common.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPermissionServiceImpl implements MyPermissionService {
    @Autowired private PermissionService permissionService;
    @Override
    public IPage<Permission> getAllPermission(int page, int limit, String name) {
        IPage<Permission> rolePage = new Page<>(page,limit);
        IPage<Permission> roleIPage=null;
        if( name != null && !name.equals("")){
            QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("permission_name",name);
            roleIPage = permissionService.page(rolePage,queryWrapper);
        }else {
            roleIPage = permissionService.page(rolePage);
        }
        return roleIPage;
    }
}
