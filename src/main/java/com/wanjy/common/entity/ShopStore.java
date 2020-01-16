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
 * 商家表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShopStore implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId
    private String shopStoreId;

    /**
     * 商家名称
     */
    private String shopStoreName;

    /**
     * 商家描述
     */
    private String shopStoreDescription;

    /**
     * 归属用户
     */
    private String shopStoreOwnerId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 逻辑删除
     */
    private Integer delStatus;


}
