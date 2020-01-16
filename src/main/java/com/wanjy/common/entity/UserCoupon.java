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
 * 用户优惠券表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserCoupon implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId
    private String userCouponId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 卡券编号
     */
    private String couponId;

    /**
     * 使用状态
     */
    private Integer useStatus;

    /**
     * 领取时间
     */
    private Date getTime;


}
