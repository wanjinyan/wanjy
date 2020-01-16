package com.wanjy.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Menu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId
    private String menuId;

    /**
     * 菜单名字
     */
    private String menuName;

    /**
     * 关联分类
     */
    private String categoryId;

    /**
     * 上级菜单
     */
    private String perMenuId;

    /**
     * 菜单状态
     */
    private Integer menuStatus;


}
