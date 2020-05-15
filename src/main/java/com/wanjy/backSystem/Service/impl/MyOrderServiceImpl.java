/**
 * Copyright (C), 2019-2020, sumeng
 * FileName: MyOrderServiceImpl
 * Author: sumeng
 * Date: 2020/5/15 14:31
 */
package com.wanjy.backSystem.Service.impl;/**
 * @ClassName: MyOrderServiceImpl
 * @Description:
 * @Author: sumeng
 * @Version: 1.0.0
 * @Date: 2020/5/15 14:31
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanjy.backSystem.Service.MyOrderService;
import com.wanjy.common.entity.Orders;
import com.wanjy.common.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @date 2020/5/15  14:31
 * @author 12068
 */
@Service
public class MyOrderServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements MyOrderService {
}
