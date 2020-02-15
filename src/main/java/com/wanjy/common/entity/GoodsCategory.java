package com.wanjy.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品类别
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsCategory implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId
    private String goodsCategoryId;

    /**
     * 类别编号
     */
    private String CategoryId;

    /**
     * 商品编号
     */
    private String goodsId;


}
