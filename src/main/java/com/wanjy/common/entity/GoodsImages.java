package com.wanjy.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品详情页表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsImages implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId
    private String goodsImagesId;

    /**
     * 图片地址
     */
    private String goodsImagesUrl;

    /**
     * 商品编号
     */
    private String goodsId;


}
