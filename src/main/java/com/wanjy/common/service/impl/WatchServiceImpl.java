package com.wanjy.common.service.impl;

import com.wanjy.common.entity.Watch;
import com.wanjy.common.mapper.WatchMapper;
import com.wanjy.common.service.WatchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关注表 服务实现类
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Service
public class WatchServiceImpl extends ServiceImpl<WatchMapper, Watch> implements WatchService {

}
