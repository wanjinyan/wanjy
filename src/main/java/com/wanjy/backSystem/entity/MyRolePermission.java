package com.wanjy.backSystem.entity;

import com.wanjy.common.entity.RolePermission;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MyRolePermission extends RolePermission {

    /**
     * 资源名字
     */
    private String permissionName;

    /**
     * 资源地址
     */
    private String permissionUrl;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色标识
     */
    private String roleFlag;
}
