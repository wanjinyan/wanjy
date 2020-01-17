package com.wanjy.common.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wanjy.backSystem.entity.MyUserDetails;
import com.wanjy.common.entity.UserDetails;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户详情表 服务类
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
public interface UserDetailsService extends IService<UserDetails> {
    public MyUserDetails getUserDetails(@Param(Constants.WRAPPER) Wrapper<MyUserDetails> queryWrapper);
}
