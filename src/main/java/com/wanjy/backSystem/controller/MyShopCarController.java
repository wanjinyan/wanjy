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
 * @author wjy
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
     * 思路：
     * 1、从Session获取登录用户的信息，主要用到user_id
     * 2、根据前端传过来购物车信息中的getGoodsNormsId调用服务层接口获取商品规格信息
     * 3、构造条件查询器，根据user_id和goods_id调用购物车服务层接口，判断购物车中有没有该商品，如果没有，就将商品数量设置为1，如果有，在该商品的数量上+1
     * 4、获取到user_id的信息，总价，单价，调用购物车服务层接口判断有无该商品，有则保存，无则更新，判断加入购物车成功，否则加入失败
     * @param request
     * @param shopCar
     * @return
     */

    @PostMapping("/addShopcar")
    public Result addShopcar(HttpServletRequest request,ShopCar shopCar){
        ActiveUser activeUser = (ActiveUser)request.getSession().getAttribute("activeUser");//获取当前用户的信息
        GoodsNorms goodsNorms = goodsNormsService.getById(shopCar.getGoodsNormsId());//根据前端传过来的goodsNormsId获取商品规格信息
        QueryWrapper<ShopCar> shopCarQueryWrapper = new QueryWrapper<>();//构造条件查询器
        shopCarQueryWrapper.eq("user_id",activeUser.getUser_id());//放入查询条件
        shopCarQueryWrapper.eq("goods_id",shopCar.getGoodsId());
        ShopCar car = shopCarService.getOne(shopCarQueryWrapper);//调用服务层接口查询该用户的改商品信息
        if(car == null){
            shopCar.setGoodNumber(1);
        }else {
            shopCar.setGoodNumber(car.getGoodNumber()+1);
        }
        shopCar.setUserId(activeUser.getUser_id());
        shopCar.setGoodAllPrice(shopCar.getGoodNumber() * goodsNorms.getGoodsNowPrice());
        shopCar.setGoodPrice(goodsNorms.getGoodsNowPrice());
        Boolean bool = shopCarService.saveOrUpdate(shopCar,shopCarQueryWrapper);//根据条件查询，如果没有该商品就保存，如果有就更新
        if(bool){
            return Result.success(shopCar.getShopCarId(),"加入购物车成功");
        }else {
            return Result.error("加入购物车失败");
        }
    }

    /**
     *获取购物车列表
     * 思路：
     * 1、从Session获取登录用户的信息，主要用到user_id
     * 2、构造条件查询器，根据user_id调用服务层接口查询该用户购物车的购物车信息
     * 3、创建myshopcar有序列表，遍历购物车，声明我的购物车对象，根据goodsid从Goosds里获取商品信息，展示时主要用到的是goodsName
     * 4、构造条件查询器，根据goodsid调用商品规格服务获取商品规格信息，包含，单价，规格，总价
     * 5、构造条件查询器，根据goods_id调用服务层接口获取对应的商品图片信息
     * 6、在myshopcar中获取到展示的信息，包含，图片信息，商品信息，商品规格，购物车id,并加入我的购物车列表中
     * @param request
     * @return
     */
    @GetMapping("/getshopcar")
    public Result getShopcar(HttpServletRequest request){
        ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");//获得用户的当前信息
        QueryWrapper<ShopCar> shopCarQueryWrapper = new QueryWrapper<>();
        shopCarQueryWrapper.eq("user_id",activeUser.getUser_id());
        List<ShopCar> shopCarList = shopCarService.list(shopCarQueryWrapper);//根据user_id获该用户取购物车信息
        List<MyShopCar> myShopCarList = new ArrayList<>();
        for (ShopCar shopCar : shopCarList) {
            MyShopCar myShopCar = new MyShopCar();
            Goods goods = goodsService.getById(shopCar.getGoodsId());//根据goodsid从Goosds里获取商品信息
            QueryWrapper<GoodsNorms> goodsNormsQueryWrapper = new QueryWrapper<>();
            goodsNormsQueryWrapper.eq("goods_id",shopCar.getGoodsId());
            List<GoodsNorms> goodsNormsList = goodsNormsService.list(goodsNormsQueryWrapper);//构造条件查询器，根据goodsid调用商品规格服务获取商品规格信息
            QueryWrapper<GoodsImages> imagesQueryWrapper = new QueryWrapper<>();
            imagesQueryWrapper.eq("goods_id",shopCar.getGoodsId());
            GoodsImages images = goodsImagesService.getOne(imagesQueryWrapper);//构造条件查询器，根据goods_id调用服务层接口获取对应的商品图片信息
            myShopCar.setImgUrl(images.getGoodsImagesUrl());
            myShopCar.setGoods(goods);
            myShopCar.setShopcarId(shopCar.getShopCarId());
            myShopCar.setGoodsNorms(goodsNormsList);
            myShopCar.setCount(shopCar.getGoodNumber());
            myShopCarList.add(myShopCar);
        }
        return Result.success(myShopCarList,myShopCarList.size());
    }

    /**
     * 根据shopCarId删除购物车信息
     * @return
     */
    @DeleteMapping("/deleteShopCar")
    public Result deleteShopCar(String shopCarId){
        Boolean bool=shopCarService.removeById(shopCarId);//根据购物车id删除购物车信息
        if(bool){
            return Result.success("删除成功");
        }else {
            return Result.error("删除失败");
        }
    }


    @GetMapping("/getShopCarTotal")
    public Result getShopCarTotal(HttpServletRequest request){
        ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
        if(activeUser == null || activeUser.getUser_id().equals("")){
            return Result.error("未登录");
        }else {
            QueryWrapper<ShopCar> shopCarQueryWrapper = new QueryWrapper<>();
            shopCarQueryWrapper.eq("user_id",activeUser.getUser_id());
            List<ShopCar> list = shopCarService.list(shopCarQueryWrapper);
            return Result.success(list);
        }
    }
}
