/**
 * Copyright (C), 2019-2020, sumeng
 * FileName: MyOrderController
 * Author: sumeng
 * Date: 2020/5/15 14:30
 */
package com.wanjy.backSystem.controller;/**
 * @ClassName: MyOrderController
 * @Description:
 * @Author: sumeng
 * @Version: 1.0.0
 * @Date: 2020/5/15 14:30
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wanjy.backSystem.Service.MyAddressService;
import com.wanjy.backSystem.Service.MyGoodsService;
import com.wanjy.backSystem.Service.MyOrderService;
import com.wanjy.backSystem.Service.MyShopStoreService;
import com.wanjy.common.entity.*;
import com.wanjy.common.service.GoodsService;
import com.wanjy.common.service.OrderDetailsService;
import com.wanjy.common.service.ShopCarService;
import com.wanjy.common.service.ShopStoreService;
import com.wanjy.common.util.GenstrUtil;
import com.wanjy.common.util.HttpUtils;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 *
 *
 * @date 2020/5/15  14:30
 * @author 12068
 */
@RestController
@RequestMapping("/orders")
public class MyOrderController {
    @Autowired private MyOrderService orderService;
    @Autowired private ShopCarService carService;
    @Autowired private GoodsService goodsService;
    @Autowired private MyGoodsService myGoodsService;
    @Autowired private OrderDetailsService detailsService;
    @Autowired private MyAddressService addressService;
    @PostMapping("/saveOrder")
    public Result saveOrder(HttpServletRequest request,String shopCarId,String personAddressId){
        ShopCar car = carService.getById(shopCarId);
        Goods goods = goodsService.getById(car.getGoodsId());
        String userId= HttpUtils.getUserId(request);
        Orders orders = new Orders();
        orders.setCreateTime(new Date());
        orders.setOrderName(GenstrUtil.generateString(18));
        orders.setUserId(userId);
        orders.setUserCouponId(null);
        orders.setPersonAddressId(personAddressId);
        orders.setOrdersStatus(0);
        orders.setOrderPrice(car.getGoodAllPrice());
        orders.setShopStoreId(goods.getShopStoreId());
        boolean save = orderService.save(orders);
        OrderDetails details=new OrderDetails();
        details.setGoodAllPrice(car.getGoodAllPrice());
        details.setGoodNumber(car.getGoodNumber());
        details.setGoodPrice(car.getGoodPrice());
        details.setGoodsId(car.getGoodsId());
        details.setOrdersId(orders.getOrdersId());
        details.setGoodsNormsId(car.getGoodsNormsId());
        boolean b = detailsService.save(details);
        return Result.isSuccess(b,"提交订单");
    }
    @GetMapping("/getOrdersByUserId")
    public Result getOrdersByUserId(HttpServletRequest request){
        String userId= HttpUtils.getUserId(request);
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<Orders> list = orderService.list(queryWrapper);
        for (Orders orders : list) {
            PersonAddress address = addressService.getById(orders.getPersonAddressId());
            orders.setPersonAddressId(address.getAddressDescription());
        }
        return Result.isSuccess(list,"获取订单");
    }
    @GetMapping("/getOrdersByStoreId")
    public Result getOrdersByStoreId(HttpServletRequest request){
        String userId= HttpUtils.getUserId(request);
        ShopStore store = myGoodsService.getShopStoreByUserId(userId);
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shop_store_id",store.getShopStoreId());
        List<Orders> list = orderService.list(queryWrapper);
        for (Orders orders : list) {
            PersonAddress address = addressService.getById(orders.getPersonAddressId());
            orders.setPersonAddressId(address.getAddressDescription());
        }
        return Result.isSuccess(list,"获取订单");
    }
    @GetMapping("/updateOderByStroeId")
    public Result updateOderByStroeId(HttpServletRequest request,Orders orders){
        boolean b = orderService.updateById(orders);
        return Result.isSuccess(b,"操作成功");
    }
}
