package com.wanjy.common.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Orders implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId
    private String ordersId;

    /**
     * 订单名称
     */

    private String orderName;

    /**
     * 订单金额
     */
    private Double orderPrice;

    /**
     * 商家
     */
    private String shopStoreId;

    /**
     * 用户
     */
    private String userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 订单状态
     */
    private Integer ordersStatus;

    /**
     * 逻辑删除
     */
    private Integer deleteStatus;

    /**
     * 收货地址
     */
    private String personAddressId;

    /**
     * 优惠券
     */
    private String userCouponId;


}
