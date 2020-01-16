package com.wanjy.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单详情表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderDetails implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId
    private String orderDetailsId;

    /**
     * 订单编号
     */

    private String ordersId;

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
