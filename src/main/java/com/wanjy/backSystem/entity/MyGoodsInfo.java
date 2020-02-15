package com.wanjy.backSystem.entity;

import com.wanjy.common.entity.Goods;
import com.wanjy.common.entity.GoodsCategory;
import com.wanjy.common.entity.GoodsImages;
import com.wanjy.common.entity.GoodsNorms;
import lombok.Data;

import java.util.List;

/**
 * @author 12068
 * @date 2020/2/4  11:36
 */
@Data
public class MyGoodsInfo {
    private Goods goods;
    private GoodsImages goodsImages;
    private List<GoodsCategory> goodsCategoryList;
    private List<GoodsNorms> goodsNormsList;
}
