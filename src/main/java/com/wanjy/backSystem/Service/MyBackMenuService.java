package com.wanjy.backSystem.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wanjy.common.entity.BackMenu;
import com.wanjy.common.util.Result;

import java.util.ArrayList;
import java.util.List;

public interface MyBackMenuService {
    public Result getAllBackMenu(String name);
}
