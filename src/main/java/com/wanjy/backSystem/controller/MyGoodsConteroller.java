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
import org.springframework.web.bind.annotation.*;

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
    @Autowired private ShopStoreService shopStoreService;
    @Autowired private MyGoodsService myGoodsService;
    @PostMapping(value = "/addGoods")
    public Result addGoods(HttpServletRequest request, MyGoods myGoods){
        ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
        //保存商品信息
        Goods goods = myGoodsService.saveGoods(myGoods, activeUser.getUser_id());
        //保存商品图片
        myGoodsService.saveImage(goods.getGoodsId(),myGoods.getGoodsImagesUrl());
        //保存商品规格
        myGoodsService.saveGoodsNorms(goods.getGoodsId(),myGoods.getGoodsNorms());
        //保存商品分类
        myGoodsService.saveCategory(goods.getGoodsId(),myGoods.getGoodsCategoryId());
        return Result.success();
    }


    @GetMapping("/getGoodsbyShop")
    public Result getGoodsbyShop(HttpServletRequest request){
        Result result = null;
        //获取登录用户的信息
        ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
        //根据登录的用户去查询相应的商家
        ShopStore shopStore=myGoodsService.getShopStoreByUserId(activeUser.getUser_id());
        //根据商家去获取相应店铺下的商品信息
        List<Goods> goodsList = myGoodsService.getGoodsByShopStoreId(shopStore.getShopStoreId());
        //根据商品表获取商品详细信息
        List<MyGoodsInfo> myGoodsInfos = myGoodsService.goodsToGoodsInfo(goodsList);
        result=Result.success(myGoodsInfos,myGoodsInfos.size());

      return result;
    }
    @GetMapping("/getGoodsInfo")
    public Result getGoodsInfo(int page, int limit,String categoryId ,String goodsName){
        Result result = null;
        List<Goods> goodsList = new ArrayList<>();
        int total = 0;
        //根据商品类别分页查询
        if(categoryId != null && !categoryId.equals("")){
            IPage<GoodsCategory> goodsCategory = myGoodsService.getGoodsCategoryByCategoryId(page, limit, categoryId);
            goodsList = myGoodsService.getGoodsByCategry(goodsCategory.getRecords());
            total = (int)goodsCategory.getTotal();
        }else {
            IPage<Goods> goodsIPage = new Page<>(page,limit);
            QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
            goodsQueryWrapper.eq("is_delete",0);
            if(goodsName != null && !goodsName.equals("")){
                goodsQueryWrapper.like("goods_name",goodsName);
            }
            goodsIPage=goodsService.page(goodsIPage,goodsQueryWrapper);
            goodsList = goodsIPage.getRecords();
            total = (int)goodsIPage.getTotal();
        }

        //根据商品表获取商品详细信息
        List<MyGoodsInfo> myGoodsInfos = myGoodsService.goodsToGoodsInfo(goodsList);
        result=Result.success(myGoodsInfos,total);
        return result;
    }

    @GetMapping("/getGoods")
    public Result getGoods(HttpServletRequest request,int page, int limit,String goodsName){
        Result result = null;
        //获取登录用户的信息
        ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
        //根据登录的用户去查询相应的商家
        ShopStore shopStore=myGoodsService.getShopStoreByUserId(activeUser.getUser_id());
        //根据商家去获取相应店铺下的商品信息
        IPage<Goods> goodsIPage = new Page<>(page,limit);
        if(goodsName != null && !goodsName.equals("")){
            QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
            goodsQueryWrapper.eq("is_delete",0);
            goodsQueryWrapper.eq("shop_store_id",shopStore.getShopStoreId());
            goodsQueryWrapper.like("goods_name", goodsName);
            goodsIPage = goodsService.page(goodsIPage,goodsQueryWrapper);
        }else {
            goodsIPage = goodsService.page(goodsIPage);
        }
        return Result.success(goodsIPage.getRecords(),(int)goodsIPage.getTotal());
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

    @DeleteMapping("/deleteGoods")
    public Result deleteGoods(String goodsId){
        Goods goods = new Goods();
        goods.setGoodsId(goodsId);
        goods.setIsDelete(1);
        boolean b = goodsService.updateById(goods);
        return Result.isSuccess(b,"更新");
    }

}
