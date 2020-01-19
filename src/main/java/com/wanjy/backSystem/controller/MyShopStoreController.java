package com.wanjy.backSystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.backSystem.Service.MyShopStoreService;
import com.wanjy.common.entity.ShopStore;
import com.wanjy.common.service.ShopStoreService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author wanjy
 * @date 2020/1/18  11:40
 */
@RestController
@RequestMapping("/shop")
public class MyShopStoreController {

    @Autowired private ShopStoreService shopStoreService;
    @Autowired private MyShopStoreService myShopStoreService;

    /**
     * 查询全部商家
     * @return
     */
    @RequestMapping("/getAllShopStore")
    public Result getAllShopStore(int page, int limit, String name){
        IPage<ShopStore> shopStoreIPage = myShopStoreService.getAllShopStore(page,limit,name);
        return Result.success(shopStoreIPage.getRecords(),(int)shopStoreIPage.getTotal());
    }
    /**
     * 查询全部商家
     * @return
     */
    @RequestMapping("/getAllShopStore2")
    public Result getAllShopStore(){
        List<ShopStore> shopStores = shopStoreService.list();
        return Result.success(shopStores,shopStores.size());
    }

    /**
     * 根据ID查询商家
     * @param ShopStoreId
     * @return
     */
    @GetMapping("/ShopStoreIdToName")
    public Result ShopStoreIdToName(String ShopStoreId){
        ShopStore shopStore = shopStoreService.getById(ShopStoreId);
        if(shopStore != null) return Result.success(shopStore);
        else return Result.error();
    }
    /**
     * 根据id删除商家
     * @param id
     * @return
     */
    @RequestMapping("/deleteShopStore")
    public Result deleteShopStore(String id){
        Boolean n = shopStoreService.removeById(id);
        if(n) return Result.success("删除成功");
        else return Result.error("删除失败");
    }

    /**
     * 根据ShopStore实体更新或保存商家
     * ShopStoreId有则更新，没有则新增
     * @param shopStore
     * @return
     */
    @RequestMapping("/saveOrUpdateShopStore")
    public Result saveOrUpdateShopStore(ShopStore shopStore){
        if(shopStore.getShopStoreId()==null || !shopStore.getShopStoreId().equals(""))
            shopStore.setCreateTime(new Date());
        Boolean n = shopStoreService.saveOrUpdate(shopStore);
        if(n) return Result.success("保存成功");
        else return Result.error("保存失败");
    }
}
