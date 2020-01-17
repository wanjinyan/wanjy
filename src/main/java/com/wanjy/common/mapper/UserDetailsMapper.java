package com.wanjy.common.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wanjy.backSystem.entity.MyRolePermission;
import com.wanjy.backSystem.entity.MyUserDetails;
import com.wanjy.common.entity.UserDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户详情表 Mapper 接口
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
public interface UserDetailsMapper extends BaseMapper<UserDetails> {
    MyUserDetails getUserDetails(@Param(Constants.WRAPPER) Wrapper<MyUserDetails> queryWrapper);
}
