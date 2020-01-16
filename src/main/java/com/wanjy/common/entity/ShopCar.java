package com.wanjy.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShopCar implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId
    private String shopCarId;

    /**
     * 用户编号
     */

    private String userId;

    /**
     * 商品编号
     */
    private String goodsId;

    /**
     * 商品规格
     */
    private String goodsNormsId;

    /**
     * 商品数量
     */
    private Integer goodNumber;

    /**
     * 商品单价
     */
    private Double goodPrice;

    /**
     * 商品总价
     */
    private Double goodAllPrice;


}
