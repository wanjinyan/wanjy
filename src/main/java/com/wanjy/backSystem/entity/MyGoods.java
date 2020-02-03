package com.wanjy.backSystem.entity;


import com.wanjy.common.entity.GoodsNorms;
import lombok.Data;

import java.util.List;

/**
 * @author 12068
 * @date 2020/2/3  12:56
 */
@Data
public class MyGoods {
    String goodsName;
    String goodsCategoryId;
    String goodsImagesUrl;
    String goodsNorms;
}
