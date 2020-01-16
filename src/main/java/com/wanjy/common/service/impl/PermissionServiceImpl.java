package com.wanjy.common.service.impl;

import com.wanjy.common.entity.Permission;
import com.wanjy.common.mapper.PermissionMapper;
import com.wanjy.common.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表（permission） 服务实现类
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
