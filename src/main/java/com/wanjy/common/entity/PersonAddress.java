package com.wanjy.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 个人收货地址表
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PersonAddress implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId
    private String personAddressId;

    /**
     * 用户编号
     */
    private String userId;
    /**
     * 联系方式
     */
    private String userTel;
    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 地址描述
     */
    private String addressDescription;

    /**
     * 地址状态 0:正常 1：删除
     */
    private Integer addressStatus;


}
