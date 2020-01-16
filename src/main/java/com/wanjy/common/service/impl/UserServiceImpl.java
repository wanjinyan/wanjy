package com.wanjy.common.service.impl;

import com.wanjy.common.entity.User;
import com.wanjy.common.mapper.UserMapper;
import com.wanjy.common.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
