package com.wanjy.backSystem.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.common.entity.ShopStore;

/**
 * @author 12068
 * @date 2020/1/18  11:42
 */
public interface MyShopStoreService {
    /**
     * 获取全部商家 可分页 可查询
     * @param page
     * @param limit
     * @param name
     * @return
             */
    public IPage<ShopStore> getAllShopStore(int page, int limit, String name);
}
