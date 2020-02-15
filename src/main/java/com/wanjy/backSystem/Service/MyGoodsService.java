package com.wanjy.backSystem.Service;

import com.wanjy.common.entity.Goods;
import com.wanjy.common.entity.GoodsCategory;
import com.wanjy.common.entity.GoodsImages;
import com.wanjy.common.entity.GoodsNorms;

import java.util.List;

/**
 * @author 12068
 * @description 商品服务层接口
 * @date 2020/2/4  10:58
 */
public interface MyGoodsService {
    public List<Goods> getGoodsByShopStoreId(String shopStoreId);
    public GoodsImages getGoodsImagesByGoodsId(String goodsId);
    public List<GoodsCategory> getGoodsCategoryByGoodsId(String goodsId);
    public List<GoodsNorms> getGoodsNormsByGoodsId(String goodsId);
}
