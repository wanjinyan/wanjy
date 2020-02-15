package com.wanjy.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 轮播表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Banner implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId
    private String bannerId;

    /**
     * 图片描述
     */
    private String bannerDescription;

    /**
     * 图片地址
     */
    private String bannerUrl;

    /**
     * 关联商品
     */
    private String goodsId;
    /**
     * 是否展示
     */
    private Integer isShow;


}
