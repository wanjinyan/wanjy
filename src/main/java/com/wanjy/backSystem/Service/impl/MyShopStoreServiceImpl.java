package com.wanjy.backSystem.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.backSystem.Service.MyShopStoreService;
import com.wanjy.common.entity.ShopStore;
import com.wanjy.common.service.ShopStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 12068
 * @date 2020/1/18  11:43
 */
@Service
public class MyShopStoreServiceImpl implements MyShopStoreService {
    @Autowired private ShopStoreService shopStoreService;
    @Override
    public IPage<ShopStore> getAllShopStore(int page, int limit, String name) {
        IPage<ShopStore> shopStorePage = new Page<>(page,limit);
        if( name != null && !name.equals("")){ //如果有名字根据名字查询，否则，查询全部 分页查询
            QueryWrapper<ShopStore> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("shop_store_name",name);
            shopStorePage = shopStoreService.page(shopStorePage,queryWrapper);
        }else {
            shopStorePage = shopStoreService.page(shopStorePage);
        }
        return shopStorePage;
    }
}
