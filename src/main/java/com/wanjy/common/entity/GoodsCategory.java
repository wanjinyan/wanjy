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
     * 类别名字
     */
    private String goodsCategoryName;

    /**
     * 类别描述
     */
    private String goodsCategoryDescription;

    /**
     * 类别状态
     */
    private Integer goodsCategoryStatus;


}
