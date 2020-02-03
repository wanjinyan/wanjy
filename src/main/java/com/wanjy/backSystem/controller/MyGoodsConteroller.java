package com.wanjy.backSystem.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanjy.backSystem.entity.MyGoods;
import com.wanjy.common.entity.*;
import com.wanjy.common.service.GoodsCategoryService;
import com.wanjy.common.service.GoodsImagesService;
import com.wanjy.common.service.GoodsNormsService;
import com.wanjy.common.service.GoodsService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping(value = "/addGoods")
    public Result addGoods(HttpServletRequest request, MyGoods myGoods){
        ActiveUser activeUser=(ActiveUser) request.getSession().getAttribute("activeUser");
        Goods goods = new Goods();
        goods.setCreateTime(new Date());
        goods.setGoodsName(myGoods.getGoodsName());
        goods.setShopStoreId(activeUser.getUser_id());
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

        return null;
    }

}
