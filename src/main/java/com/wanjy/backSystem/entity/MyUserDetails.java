package com.wanjy.backSystem.entity;

import com.wanjy.common.entity.User;
import lombok.Data;

@Data
public class MyUserDetails extends User {

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证
     */
    private String idCard;
}
