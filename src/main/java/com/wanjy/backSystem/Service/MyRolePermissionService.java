package com.wanjy.backSystem.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.backSystem.entity.MyRolePermission;
import com.wanjy.common.entity.RolePermission;


/**
 * 这是自定义的授权服务层接口
 */
public interface MyRolePermissionService {
    /**
     * 获取全部授权资源 可分页 可查询
     * @param page
     * @param limit
     * @param permissionName
     * @param roleName
     * @return
     */
    public IPage<MyRolePermission> getAllRolePermission(int page, int limit,String roleName, String permissionName);
}
