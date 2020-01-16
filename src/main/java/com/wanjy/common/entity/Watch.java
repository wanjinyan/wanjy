package com.wanjy.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 关注表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Watch implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId
    private String watchId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 商品或商家编号
     */
    private String goodsId;

    /**
     * 关注类型 0:商家，1:商品
     */
    private Integer type;

    /**
     * 逻辑删除  0:删除，1:正常
     */
    private Integer deleteStatus;


}
