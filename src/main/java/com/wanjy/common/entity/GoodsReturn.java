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
 * 商品反馈表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsReturn implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId
    private String goodsReturnId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 反馈详情
     */
    private String returnDescription;

    /**
     * 上级反馈
     */
    private String perReturnId;

    /**
     * 反馈时间
     */
    private Date createTime;


}
