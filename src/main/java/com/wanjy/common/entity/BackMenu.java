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
 * 菜单表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BackMenu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 菜单id
     */
    @TableId
    private String menuId;

    /**
     * 菜单名字
     */
    private String title;

    /**
     * 排序
     */
    private Integer orderNumber;

    /**
     * 菜单地址
     */
    private String href;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 权限
     */
    private String authority;

    /**
     * 选择
     */
    private Integer checked;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 菜单类型
     */
    private Integer isMenu;

    /**
     * 父级菜单
     */
    private String parentId;

    /**
     * 展示方式
     */
    private String target;
}
