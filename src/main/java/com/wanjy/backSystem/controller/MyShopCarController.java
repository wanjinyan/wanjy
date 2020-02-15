package com.wanjy.backSystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wanjy.backSystem.entity.MyShopCar;
import com.wanjy.common.entity.*;
import com.wanjy.common.service.GoodsImagesService;
import com.wanjy.common.service.GoodsNormsService;
import com.wanjy.common.service.GoodsService;
import com.wanjy.common.service.ShopCarService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 12068
 * @date 2020/2/8  13:21
 */
@RestController
@RequestMapping("/shopcar")
public class MyShopCarController {
    @Autowired private ShopCarService shopCarService;
    @Autowired private GoodsNormsService goodsNormsService;
    @Autowired private GoodsService goodsService;
    @Autowired private GoodsImagesService goodsImagesService;

    /**
     * 判断购物车里面有没有该商品，如果有，将购物车里面的商品数量+1
     * 如果没有，就新增一条数据
     * @param request
     * @param shopCar
     * @return
     */

    @PostMapping("/addShopcar")
    public Result addShopcar(HttpServletRequest request,ShopCar shopCar){
        ActiveUser activeUser=(ActiveUser) request.getSession().getAttribute("activeUser");
        GoodsNorms goodsNorms=goodsNormsService.getById(shopCar.getGoodsNormsId());
        QueryWrapper<ShopCar> shopCarQueryWrapper = new QueryWrapper<>();
        shopCarQueryWrapper.eq("user_id",activeUser.getUser_id());
        shopCarQueryWrapper.eq("goods_id",shopCar.getGoodsId());
        ShopCar car = shopCarService.getOne(shopCarQueryWrapper);
        if(car == null){
            shopCar.setGoodNumber(1);
        }else {
            shopCar.setGoodNumber(car.getGoodNumber()+1);
        }
        shopCar.setGoodAllPrice(1*goodsNorms.getGoodsNowPrice());
        shopCar.setUserId(activeUser.getUser_id());
        shopCar.setGoodPrice(goodsNorms.getGoodsNowPrice());
        Boolean bool = shopCarService.saveOrUpdate(shopCar,shopCarQueryWrapper);
        if(bool){
            return Result.success("加入购物车成功");
        }else {
            return Result.error("加入购物车失败");
        }
    }
    @GetMapping("/getshopcar")
    public Result getShopcar(HttpServletRequest request){
        ActiveUser activeUser = (ActiveUser)request.getSession().getAttribute("activeUser");//获取当前的用户信息
        QueryWrapper<ShopCar> carQueryWrapper = new QueryWrapper<>();//构造购物车的条件构造器
        carQueryWrapper.eq("user_id",activeUser.getUser_id());//往构造器里面放入根据user_id查询的条件
        List<ShopCar> list = shopCarService.list(carQueryWrapper);//调用服务层接口查询用户购物车信息
        List<MyShopCar> myShopCarList = new ArrayList<>();
        for (ShopCar shopCar : list) {
            MyShopCar myShopCar = new MyShopCar();
            Goods goods = goodsService.getById(shopCar.getGoodsId());//根据商品id获取商品信息
            QueryWrapper<GoodsNorms> normsQueryWrapper = new QueryWrapper<>();//构造商品规格的条件构造器
            normsQueryWrapper.eq("goods_id",shopCar.getGoodsId());//往构造器里面放入根据goods_id查询的条件
            List<GoodsNorms> goodsNormsList = goodsNormsService.list(normsQueryWrapper);//调用服务层接口查询商品规格信息
            QueryWrapper<GoodsImages> imagesQueryWrapper = new QueryWrapper<>();
            imagesQueryWrapper.eq("goods_id",shopCar.getGoodsId());//往构造器里面放入根据goods_id查询的条件
            GoodsImages images = goodsImagesService.getOne(imagesQueryWrapper);//调用服务层接口查询商品图片信息
            myShopCar.setCount(shopCar.getGoodNumber());
            myShopCar.setGoods(goods);
            myShopCar.setGoodsNorms(goodsNormsList);
            myShopCar.setImgUrl(images.getGoodsImagesUrl());
            myShopCar.setShopcarId(shopCar.getShopCarId());
            myShopCarList.add(myShopCar);
        }
        return Result.success(myShopCarList,myShopCarList.size());
    }
    @DeleteMapping("/deleteShopCar")
    public Result deleteShopCar(String shopCarId){
        Boolean bool=shopCarService.removeById(shopCarId);
        if(bool){
            return Result.success("删除成功");
        }else {
            return Result.error("删除失败");
        }
    }
}
