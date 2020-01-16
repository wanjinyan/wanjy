package com.wanjy.common.service.impl;

import com.wanjy.common.entity.PersonAddress;
import com.wanjy.common.mapper.PersonAddressMapper;
import com.wanjy.common.service.PersonAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 个人收货地址表 服务实现类
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Service
public class PersonAddressServiceImpl extends ServiceImpl<PersonAddressMapper, PersonAddress> implements PersonAddressService {

}
