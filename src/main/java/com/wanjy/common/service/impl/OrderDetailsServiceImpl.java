package com.wanjy.common.service.impl;

import com.wanjy.common.entity.OrderDetails;
import com.wanjy.common.mapper.OrderDetailsMapper;
import com.wanjy.common.service.OrderDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Service
public class OrderDetailsServiceImpl extends ServiceImpl<OrderDetailsMapper, OrderDetails> implements OrderDetailsService {

}
