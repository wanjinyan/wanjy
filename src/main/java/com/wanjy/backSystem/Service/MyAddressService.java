package com.wanjy.backSystem.Service;

import com.wanjy.common.entity.PersonAddress;
import com.wanjy.common.service.PersonAddressService;

import java.util.List;

/**
 * @author 12068
 * @date 2020/5/15  9:19
 */
public interface MyAddressService extends PersonAddressService {
    List<PersonAddress> getAddress(String userId);
}
