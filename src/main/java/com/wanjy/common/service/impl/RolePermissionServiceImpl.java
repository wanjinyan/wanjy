package com.wanjy.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.backSystem.entity.MyRolePermission;
import com.wanjy.common.entity.RolePermission;
import com.wanjy.common.mapper.RolePermissionMapper;
import com.wanjy.common.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {
    @Override
    public IPage<MyRolePermission> getRolePerssion(IPage<MyRolePermission> page) {
        return baseMapper.getRolePerssion(page);
    }

    @Override
    public IPage<MyRolePermission> getRolePerssion(IPage<MyRolePermission> page, Wrapper<MyRolePermission> queryWrapper) {
        return baseMapper.getRolePerssionByOrder(page,queryWrapper);
    }
}
