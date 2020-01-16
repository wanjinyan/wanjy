package com.wanjy.backSystem.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.common.entity.Role;

public interface MyRoleService {
    /**
     * 获取全部角色 可分页 可查询
     * @param page
     * @param limit
     * @param name
     * @return
     */
    public IPage<Role> getAllRole(int page,int limit,String name);
}
