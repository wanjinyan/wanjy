package com.wanjy.common.service.impl;

import com.wanjy.common.entity.UserDetails;
import com.wanjy.common.mapper.UserDetailsMapper;
import com.wanjy.common.service.UserDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户详情表 服务实现类
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Service
public class UserDetailsServiceImpl extends ServiceImpl<UserDetailsMapper, UserDetails> implements UserDetailsService {

}
