/**
 * Copyright (C), 2019-2020, sumeng
 * FileName: MyAddressController
 * Author: sumeng
 * Date: 2020/5/15 9:17
 */
package com.wanjy.backSystem.controller;/**
 * @ClassName: MyAddressController
 * @Description:
 * @Author: sumeng
 * @Version: 1.0.0
 * @Date: 2020/5/15 9:17
 */

import com.wanjy.backSystem.Service.MyAddressService;
import com.wanjy.common.entity.PersonAddress;
import com.wanjy.common.util.HttpUtils;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 * @date 2020/5/15  9:17
 * @author 12068
 */
@RestController
@RequestMapping("/address")
public class MyAddressController {
    @Autowired private MyAddressService addressService;

    @PostMapping("/saveAddress")
    public Result saveAddress(HttpServletRequest request,PersonAddress address){
        String userId= HttpUtils.getUserId(request);
        address.setUserId(userId);
        if (address.getAddressStatus()==null || address.getAddressStatus().equals("")){
            address.setAddressStatus(0);
        }
        return Result.isSuccess(addressService.saveOrUpdate(address),"保存地址");
    }
    @GetMapping("/getAddress")
    public Result getAddress(HttpServletRequest request){
        String userId= HttpUtils.getUserId(request);
        return Result.isSuccess(addressService.getAddress(userId),"获取地址");
    }
}
