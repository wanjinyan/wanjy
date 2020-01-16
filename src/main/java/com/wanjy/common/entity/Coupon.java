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
 * 优惠券表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Coupon implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId
    private String couponId;

    /**
     * 商家编号
     */
    private String shopStoreId;

    /**
     * 优惠金额
     */
    private Double couponPrice;

    /**
     * 优惠条件
     */
    private Double couponFactor;

    /**
     * 开始时间
     */
    private Date couponStartTime;

    /**
     * 结束时间
     */
    private Date couponEndTime;

    /**
     * 优惠券数量
     */
    private Integer couponNumber;

    /**
     * 优惠券状态
     */
    private Integer couponStatus;


}
