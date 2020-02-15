package com.wanjy.backSystem.entity;

import com.wanjy.common.entity.Goods;
import com.wanjy.common.entity.GoodsNorms;
import lombok.Data;

import java.util.List;

/**
 * @author 12068
 * @date 2020/2/14  20:58
 */

@Data
public class MyShopCar {
    String shopcarId;
    String imgUrl;
    int count;
    Goods goods;
    List<GoodsNorms> goodsNorms;
}
