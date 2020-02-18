package com.wanjy.backSystem.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.backSystem.Service.MyGoodsService;
import com.wanjy.backSystem.entity.MyGoods;
import com.wanjy.backSystem.entity.MyGoodsInfo;
import com.wanjy.common.entity.*;
import com.wanjy.common.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 12068
 * @date 2020/2/4  10:59
 */
@Service
public class MyGoodsServiceImpl implements MyGoodsService {
    @Autowired private GoodsService goodsService;
    @Autowired private GoodsNormsService goodsNormsService;
    @Autowired private GoodsImagesService goodsImagesService;
    @Autowired private GoodsCategoryService goodsCategoryService;
    @Autowired private ShopStoreService shopStoreService;
    @Override
    public Goods saveGoods(MyGoods myGoods,String userId) {
        Goods goods = new Goods();
        goods.setCreateTime(new Date());
        goods.setGoodsName(myGoods.getGoodsName());
        goods.setShopStoreId(getShopStoreByUserId(userId).getShopStoreId());
        goodsService.save(goods);
        return goods;
    }

    @Override
    public Boolean saveImage(String goodsId,String goodsImagesUrl) {
        GoodsImages goodsImages=new GoodsImages();
        goodsImages.setGoodsId(goodsId);
        goodsImages.setGoodsImagesUrl(goodsImagesUrl);
        boolean b = goodsImagesService.save(goodsImages);
        return b;
    }

    @Override
    public IPage<GoodsCategory> getGoodsCategoryByCategoryId(int page, int limit,String categoryId) {
        IPage<GoodsCategory> goodsCategoryIPage = new Page<>(page,limit);
        QueryWrapper<GoodsCategory> goodsCategoryQueryWrapper = new QueryWrapper<>();
        goodsCategoryQueryWrapper.eq("category_id",categoryId);
        goodsCategoryIPage = goodsCategoryService.page(goodsCategoryIPage,goodsCategoryQueryWrapper);
        return goodsCategoryIPage;
    }

    @Override
    public List<Goods> getGoodsByCategry(List<GoodsCategory> goodsCategoryList) {
        List<Goods> goodsList = new ArrayList<>();
        for (GoodsCategory goodsCategory : goodsCategoryList) {
            Goods goods = goodsService.getById(goodsCategory.getGoodsId());
            if(goods.getIsDelete()==0){
                goodsList.add(goods);
            }
        }
        return goodsList;
    }

    @Override
    public Boolean saveGoodsNorms(String goodsId,String goodsNormstr) {
        List<GoodsNorms> goodsNorms = new ArrayList<>();
        goodsNorms= JSONObject.parseArray(goodsNormstr, GoodsNorms.class);//把json字符串转化为对象数组
        for (GoodsNorms goodsNorm : goodsNorms) {
            goodsNorm.setGoodsId(goodsId);
        }
        boolean b = goodsNormsService.saveBatch(goodsNorms);
        return b;
    }

    @Override
    public Boolean saveCategory(String goodsId,String goodsCategoryId) {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setCategoryId(goodsCategoryId);
        goodsCategory.setGoodsId(goodsId);
        boolean b = goodsCategoryService.save(goodsCategory);
        return b;
    }

    @Override
    public ShopStore getShopStoreByUserId(String userId) {
        QueryWrapper<ShopStore> shopStoreQueryWrapper=new QueryWrapper<>();
        shopStoreQueryWrapper.eq("shop_store_owner_id",userId);
        ShopStore shopStore=shopStoreService.getOne(shopStoreQueryWrapper);
        return shopStore;
    }

    @Override
    public List<MyGoodsInfo> goodsToGoodsInfo(List<Goods> goodsList) {
        List<MyGoodsInfo> myGoodsInfos = new ArrayList<>();
        //由于数据库设计商品信息表关联了 商品表 商品规格表 商品分类表 所以我们需要去查询其他的相关信息封装在一个类里，传给前端。
        for (Goods goods : goodsList) {
            MyGoodsInfo myGoodsInfo = new MyGoodsInfo();
            myGoodsInfo.setGoods(goods);
            //查询商品的图片
            GoodsImages goodsImages = getGoodsImagesByGoodsId(goods.getGoodsId());
            myGoodsInfo.setGoodsImages(goodsImages);
            //查询商品的类别
            List<GoodsCategory> goodsCategoryList = getGoodsCategoryByGoodsId(goods.getGoodsId());
            myGoodsInfo.setGoodsCategoryList(goodsCategoryList);
            //查询商品规格
            List<GoodsNorms> goodsNorms=getGoodsNormsByGoodsId(goods.getGoodsId());
            myGoodsInfo.setGoodsNormsList(goodsNorms);
            myGoodsInfos.add(myGoodsInfo);
        }
        return myGoodsInfos;
    }

    @Override
    public List<Goods> getGoodsByShopStoreId(String shopStoreId) {
        QueryWrapper<Goods> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("shop_store_id",shopStoreId);
        List<Goods> goodsList = goodsService.list(queryWrapper);
        return goodsList;
    }

    @Override
    public GoodsImages getGoodsImagesByGoodsId(String goodsId) {
        QueryWrapper<GoodsImages> imagesQueryWrapper = new QueryWrapper<>();
        imagesQueryWrapper.eq("goods_id",goodsId);
        GoodsImages goodsImages = goodsImagesService.getOne(imagesQueryWrapper);
        return goodsImages;
    }

    @Override
    public List<GoodsCategory> getGoodsCategoryByGoodsId(String goodsId) {
        QueryWrapper<GoodsCategory> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.eq("goods_id",goodsId);
        List<GoodsCategory> goodsCategoryList=goodsCategoryService.list(categoryQueryWrapper);
        return goodsCategoryList;
    }

    @Override
    public List<GoodsNorms> getGoodsNormsByGoodsId(String goodsId) {
        QueryWrapper<GoodsNorms> goodsNormsQueryWrapper = new QueryWrapper<>();
        goodsNormsQueryWrapper.eq("goods_id",goodsId);
        List<GoodsNorms> goodsNorms=goodsNormsService.list(goodsNormsQueryWrapper);
        return goodsNorms;
    }
}
