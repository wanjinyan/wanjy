package com.wanjy.backSystem.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.backSystem.Service.MyRoleService;
import com.wanjy.common.entity.Role;
import com.wanjy.common.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyRoleServiceImpl implements MyRoleService {
    @Autowired private RoleService roleService;
    @Override
    public IPage<Role> getAllRole(int page, int limit, String name) {
        IPage<Role> rolePage = new Page<>(page,limit);
        IPage<Role> roleIPage=null;
        if( name != null && !name.equals("")){ //如果有名字根据名字查询，否则，查询全部 分页查询
            QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("role_name",name);
            roleIPage = roleService.page(rolePage,queryWrapper);
        }else {
            roleIPage = roleService.page(rolePage);
        }
        return roleIPage;
    }
}
