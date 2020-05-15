package com.wanjy.backSystem.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanjy.backSystem.Service.MyAddressService;
import com.wanjy.common.entity.PersonAddress;
import com.wanjy.common.mapper.PersonAddressMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 12068
 * @date 2020/5/15  9:19
 */
@Service
public class MyAddressServiceImpl extends ServiceImpl<PersonAddressMapper, PersonAddress> implements MyAddressService {

    @Override
    public List<PersonAddress> getAddress(String userId) {
        QueryWrapper<PersonAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("address_status",0);
        List<PersonAddress> list = list(queryWrapper);
        return list;
    }
}
