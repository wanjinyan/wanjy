package com.wanjy.backSystem.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.common.entity.BackMenu;
import com.wanjy.common.util.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface MyBackMenuService {
    public Result getAllBackMenu(String name);
    /**
     * 获取全部资源 可分页 可查询
     * @param page
     * @param limit
     * @param name
     * @return
     */
    public IPage<BackMenu> getAllBackMenu(int page, int limit, String name);
    public Map getAllRoleBackMenu(String role);
}
