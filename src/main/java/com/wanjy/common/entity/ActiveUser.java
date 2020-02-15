package com.wanjy.common.entity;

import lombok.Data;

/**
 * 活动用户类
 */
@Data
public class ActiveUser implements java.io.Serializable{
    private String user_id;//用户id
    private String nickname;//用户名字
    private String account;//用户账号
    private String role;
}
