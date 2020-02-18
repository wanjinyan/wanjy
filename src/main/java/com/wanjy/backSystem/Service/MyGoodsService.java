package com.wanjy.backSystem.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.backSystem.entity.MyGoods;
import com.wanjy.backSystem.entity.MyGoodsInfo;
import com.wanjy.common.entity.*;

import java.util.List;

/**
 * @author 12068
 * @description 商品服务层接口
 * @date 2020/2/4  10:58
 */
public interface MyGoodsService {
    public Goods saveGoods(MyGoods myGoods,String userId);
    public Boolean saveImage(String goodsId,String goodsImagesUrl);
    public IPage<GoodsCategory> getGoodsCategoryByCategoryId(int page, int limit, String categoryId);
    public List<Goods> getGoodsByCategry(List<GoodsCategory> goodsCategoryList);
    public Boolean saveGoodsNorms(String goodsId,String goodsNormstr);
    public Boolean saveCategory(String goodsId,String goodsCategoryId);
    public ShopStore getShopStoreByUserId(String userId);
    public List<MyGoodsInfo> goodsToGoodsInfo(List<Goods> goodsList);
    public List<Goods> getGoodsByShopStoreId(String shopStoreId);
    public GoodsImages getGoodsImagesByGoodsId(String goodsId);
    public List<GoodsCategory> getGoodsCategoryByGoodsId(String goodsId);
    public List<GoodsNorms> getGoodsNormsByGoodsId(String goodsId);
}
