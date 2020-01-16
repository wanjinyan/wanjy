package com.wanjy.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表（permission）
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId
    private String permissionId;

    /**
     * 权限名字
     */
    private String permissionName;

    /**
     * 权限地址
     */
    private String permissionUrl;

    /**
     * 权限描述
     */
    private String permissionDescription;


}
