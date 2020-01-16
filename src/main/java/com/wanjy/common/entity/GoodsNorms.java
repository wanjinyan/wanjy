package com.wanjy.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品规格表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsNorms implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId
    private String goodsNormsId;

    /**
     * 商品编号
     */
    private String goodsId;

    /**
     * 商品原价
     */
    private Double goodsOldPrice;

    /**
     * 商品现价
     */
    private Double goodsNowPrice;

    /**
     * 商品规格名称
     */
    private String goodsName;

    /**
     * 商品状态
     */
    private Integer goodsStatus;

    /**
     * 商品库存
     */
    private Integer goodsNumber;


}
