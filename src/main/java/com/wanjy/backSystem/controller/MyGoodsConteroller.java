package com.wanjy.backSystem.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.backSystem.Service.MyGoodsService;
import com.wanjy.backSystem.entity.MyGoods;
import com.wanjy.backSystem.entity.MyGoodsInfo;
import com.wanjy.common.entity.*;
import com.wanjy.common.service.*;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 12068
 * @date 2020/2/3  12:45
 */
@RestController
@RequestMapping("/goods")
public class MyGoodsConteroller {
    @Autowired private GoodsService goodsService;
    @Autowired private GoodsNormsService goodsNormsService;
    @Autowired private GoodsImagesService goodsImagesService;
    @Autowired private GoodsCategoryService goodsCategoryService;
    @Autowired private ShopStoreService shopStoreService;
    @Autowired private MyGoodsService myGoodsService;
    @PostMapping(value = "/addGoods")
    public Result addGoods(HttpServletRequest request, MyGoods myGoods){
        ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
        //根据登录的用户去查询相应的商家
        QueryWrapper<ShopStore> shopStoreQueryWrapper=new QueryWrapper<>();
        shopStoreQueryWrapper.eq("shop_store_owner_id",activeUser.getUser_id());
        ShopStore shopStore=shopStoreService.getOne(shopStoreQueryWrapper);
        Goods goods = new Goods();
        goods.setCreateTime(new Date());
        goods.setGoodsName(myGoods.getGoodsName());
        goods.setShopStoreId(shopStore.getShopStoreId());
        goodsService.save(goods);
        GoodsImages goodsImages=new GoodsImages();
        goodsImages.setGoodsId(goods.getGoodsId());
        goodsImages.setGoodsImagesUrl(myGoods.getGoodsImagesUrl());
        goodsImagesService.save(goodsImages);
        List<GoodsNorms> goodsNorms = new ArrayList<>();
        String goodsNormstr=myGoods.getGoodsNorms();
        goodsNorms= JSONObject.parseArray(goodsNormstr, GoodsNorms.class);
        for (GoodsNorms goodsNorm : goodsNorms) {
            goodsNorm.setGoodsId(goods.getGoodsId());
        }
        goodsNormsService.saveBatch(goodsNorms);
        System.out.println(myGoods);

        return Result.success();
    }


    @GetMapping("/getGoodsbyShop")
    public Result getGoodsbyShop(HttpServletRequest request){
        Result result = null;
        //获取登录用户的信息
        ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
        //根据登录的用户去查询相应的商家
        ShopStore shopStore=shopStoreService.getById(activeUser.getUser_id());
        //根据商家去获取相应店铺下的商品信息
        List<Goods> goodsList = myGoodsService.getGoodsByShopStoreId(shopStore.getShopStoreId());
        List<MyGoodsInfo> myGoodsInfos = new ArrayList<>();
        //由于数据库设计商品信息表关联了 商品表 商品规格表 商品分类表 所以我们需要去查询其他的相关信息封装在一个类里，传给前端。
        for (Goods goods : goodsList) {
            MyGoodsInfo myGoodsInfo = new MyGoodsInfo();
            myGoodsInfo.setGoods(goods);
            //查询商品的图片
            GoodsImages goodsImages = myGoodsService.getGoodsImagesByGoodsId(goods.getGoodsId());
            myGoodsInfo.setGoodsImages(goodsImages);
            //查询商品的类别
            List<GoodsCategory> goodsCategoryList = myGoodsService.getGoodsCategoryByGoodsId(goods.getGoodsId());
            myGoodsInfo.setGoodsCategoryList(goodsCategoryList);
            //查询商品规格
            List<GoodsNorms> goodsNorms=myGoodsService.getGoodsNormsByGoodsId(goods.getGoodsId());
            myGoodsInfo.setGoodsNormsList(goodsNorms);
            myGoodsInfos.add(myGoodsInfo);
        }
        result=Result.success(myGoodsInfos,myGoodsInfos.size());

      return result;
    }
    @GetMapping("/getGoodsInfo")
    public Result getGoodsInfo(int page, int limit){
        Result result = null;
        //根据商家去获取相应店铺下的商品信息
        IPage<Goods> goodsIPage = new Page<>(page,limit);
        goodsIPage=goodsService.page(goodsIPage);
        List<Goods> goodsList = goodsIPage.getRecords();
        List<MyGoodsInfo> myGoodsInfos = new ArrayList<>();
        //由于数据库设计商品信息表关联了 商品表 商品规格表 商品分类表 所以我们需要去查询其他的相关信息封装在一个类里，传给前端。
        for (Goods goods : goodsList) {
            MyGoodsInfo myGoodsInfo = new MyGoodsInfo();
            myGoodsInfo.setGoods(goods);
            //查询商品的图片
            GoodsImages goodsImages = myGoodsService.getGoodsImagesByGoodsId(goods.getGoodsId());
            myGoodsInfo.setGoodsImages(goodsImages);
            //查询商品的类别
            List<GoodsCategory> goodsCategoryList = myGoodsService.getGoodsCategoryByGoodsId(goods.getGoodsId());
            myGoodsInfo.setGoodsCategoryList(goodsCategoryList);
            //查询商品规格
            List<GoodsNorms> goodsNorms=myGoodsService.getGoodsNormsByGoodsId(goods.getGoodsId());
            myGoodsInfo.setGoodsNormsList(goodsNorms);
            myGoodsInfos.add(myGoodsInfo);
        }
        result=Result.success(myGoodsInfos,myGoodsInfos.size());

        return result;
    }
    @GetMapping("/getGoodsInfoBygoodsId")
    public Result getGoodsInfo(String goodsId){
        Result result = null;
        Goods goods = goodsService.getById(goodsId);
        MyGoodsInfo myGoodsInfo = new MyGoodsInfo();
        myGoodsInfo.setGoods(goods);
        //查询商品的图片
        GoodsImages goodsImages = myGoodsService.getGoodsImagesByGoodsId(goods.getGoodsId());
        myGoodsInfo.setGoodsImages(goodsImages);
        //查询商品的类别
        List<GoodsCategory> goodsCategoryList = myGoodsService.getGoodsCategoryByGoodsId(goods.getGoodsId());
        myGoodsInfo.setGoodsCategoryList(goodsCategoryList);
        //查询商品规格
        List<GoodsNorms> goodsNorms=myGoodsService.getGoodsNormsByGoodsId(goods.getGoodsId());
        myGoodsInfo.setGoodsNormsList(goodsNorms);
        result=Result.success(myGoodsInfo,1);

        return result;
    }
    @GetMapping("/getGoodsByShopId")
    public Result getGoodsByShopId(String shopId){
        Result result = null;
        List<Goods> goodsList = myGoodsService.getGoodsByShopStoreId(shopId);
        result=Result.success(goodsList,goodsList.size());
        return result;
    }

}
