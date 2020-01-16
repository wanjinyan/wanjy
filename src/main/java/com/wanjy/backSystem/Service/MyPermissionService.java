package com.wanjy.backSystem.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.common.entity.Permission;

public interface MyPermissionService {
    /**
     * 获取全部资源 可分页 可查询
     * @param page
     * @param limit
     * @param name
     * @return
     */
    public IPage<Permission> getAllPermission(int page, int limit, String name);
}
