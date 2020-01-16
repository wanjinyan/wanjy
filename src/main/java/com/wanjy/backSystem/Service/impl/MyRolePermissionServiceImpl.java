package com.wanjy.backSystem.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.backSystem.Service.MyRolePermissionService;
import com.wanjy.backSystem.entity.MyRolePermission;
import com.wanjy.common.entity.RolePermission;
import com.wanjy.common.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 这是自定义的授权服务层接口实现
 */
@Service //声明它是服务层
public class MyRolePermissionServiceImpl implements MyRolePermissionService {
    @Autowired
    private RolePermissionService rolePermissionService;
    @Override
    public IPage<MyRolePermission> getAllRolePermission(int page, int limit,String roleName, String permissionName) {
        IPage<MyRolePermission> rolePage = new Page<>(page,limit);
        IPage<MyRolePermission> roleIPage=null;
        QueryWrapper<MyRolePermission> queryWrapper = new QueryWrapper<>();
        if((roleName != null && !roleName.equals("")) || (permissionName != null && !permissionName.equals(""))){
            if(roleName != null && !roleName.equals(""))
                queryWrapper.like("role.role_name",roleName);
            if(permissionName != null && !permissionName.equals(""))
                queryWrapper.like("permission.permission_name",permissionName);
            roleIPage=rolePermissionService.getRolePerssion(rolePage,queryWrapper);
        }else {
            roleIPage=rolePermissionService.getRolePerssion(rolePage);
        }
        return roleIPage;
    }
}


