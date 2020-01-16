package com.wanjy.common.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wanjy.backSystem.entity.MyRolePermission;
import com.wanjy.common.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色权限表 Mapper 接口
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    IPage<MyRolePermission> getRolePerssionByOrder(IPage<MyRolePermission> page, @Param(Constants.WRAPPER) Wrapper<MyRolePermission> queryWrapper);

    IPage<MyRolePermission> getRolePerssion(IPage<MyRolePermission> page);
    List<MyRolePermission> getAllRolePermission();
}
