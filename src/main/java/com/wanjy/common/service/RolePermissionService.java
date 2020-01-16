package com.wanjy.common.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wanjy.backSystem.entity.MyRolePermission;
import com.wanjy.common.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 角色权限表 服务类
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
public interface RolePermissionService extends IService<RolePermission> {
    /**
     * 自定义分页查询全部授权资源接口
     * @param page
     * @return
     */
    IPage<MyRolePermission> getRolePerssion(IPage<MyRolePermission> page);

    /**
     * 自定义根据条件分页查询全部授权资源接口
     * @param page
     * @param queryWrapper
     * @return
     */
    IPage<MyRolePermission> getRolePerssion(IPage<MyRolePermission> page, @Param(Constants.WRAPPER) Wrapper<MyRolePermission> queryWrapper);

    public List<MyRolePermission> getAllRolePermission();
}
