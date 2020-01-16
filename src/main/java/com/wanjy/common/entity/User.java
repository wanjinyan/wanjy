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
 * 用户表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId
    private String userId;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 加密盐值
     */
    private String salt;

    /**
     * 用户角色
     */
    private String roleId;

    /**
     * 用户状态 用户状态(0:逻辑删除，1:正常，2:锁定，3：违规)
     */
    private Integer userStatus;

    /**
     * 注册时间
     */
    private Date registerTime;


}
