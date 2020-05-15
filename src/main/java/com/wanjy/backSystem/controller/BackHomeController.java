package com.wanjy.backSystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.backSystem.Service.MyOrderService;
import com.wanjy.backSystem.entity.MyTotal;
import com.wanjy.common.entity.BackMenu;
import com.wanjy.common.entity.User;
import com.wanjy.common.service.*;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12068
 * @date 2020/2/17  21:05
 */
@RestController
@RequestMapping("/backhome")
public class BackHomeController {
    @Autowired private UserService userService;
    @Autowired private ShopStoreService shopStoreService;
    @Autowired private GoodsService goodsService;
    @Autowired private MyOrderService ordersService;
    @Autowired private BackMenuService backMenuService;
    /**
     * 获取统计数据
     * @return
     */
    @GetMapping("/getTotal")
    public Result getTotal(){
        List<MyTotal> myTotalList = new ArrayList<>();
        MyTotal myTotal=new MyTotal();
        myTotal.setTitle("用户统计");
        myTotal.setTotal(userService.count());
        myTotal.setUpdateTime("实时");
        myTotalList.add(myTotal);
        myTotal=new MyTotal();
        myTotal.setTitle("商家统计");
        myTotal.setTotal(shopStoreService.count());
        myTotal.setUpdateTime("实时");
        myTotalList.add(myTotal);
        myTotal=new MyTotal();
        myTotal.setTitle("商品统计");
        myTotal.setTotal(goodsService.count());
        myTotal.setUpdateTime("实时");
        myTotalList.add(myTotal);
        myTotal=new MyTotal();
        myTotal.setTitle("订单统计");
        myTotal.setTotal(ordersService.count());
        myTotal.setUpdateTime("实时");
        myTotalList.add(myTotal);
        return Result.success(myTotalList);
    }
    @GetMapping("/getMenu")
    public Result getMenu(){
        IPage<BackMenu> backMenuIPage = new Page<>(1,8);
        QueryWrapper<BackMenu> backMenuQueryWrapper = new QueryWrapper<>();
        backMenuQueryWrapper
                .ne("href","")
                .isNotNull("href");
        backMenuIPage=backMenuService.page(backMenuIPage,backMenuQueryWrapper);
        return Result.success(backMenuIPage.getRecords());
    }
}
