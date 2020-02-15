package com.wanjy.backSystem.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wanjy.backSystem.Service.MyGoodsService;
import com.wanjy.common.entity.Goods;
import com.wanjy.common.entity.GoodsCategory;
import com.wanjy.common.entity.GoodsImages;
import com.wanjy.common.entity.GoodsNorms;
import com.wanjy.common.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
