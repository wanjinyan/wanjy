package com.wanjy.backSystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wanjy.common.entity.Banner;
import com.wanjy.common.service.BannerService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 12068
 * @date 2020/2/5  14:06
 */

@RestController
@RequestMapping("/banner")
public class MyBannerController {
    @Autowired private BannerService bannerService;

    @PostMapping("/savebanner")
    public Result addBanner(Banner banner){
        Boolean bool =  bannerService.saveOrUpdate(banner);
        if(bool){
            return Result.success();
        }else {
            return Result.error("数据异常");
        }
    }

    @GetMapping("/getAllBanner")
    public Result getAllBanner(){
        List<Banner> bannerList = bannerService.list();
        if(bannerList!=null){
            return Result.success(bannerList,bannerList.size());
        }else {
            return Result.error("数据异常");
        }
    }
    @GetMapping("/getbanner")
    public Result getbanner(){
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_show",1);
        List<Banner> bannerList = bannerService.list(queryWrapper);
        if(bannerList!=null){
            return Result.success(bannerList,bannerList.size());
        }else {
            return Result.error("数据异常");
        }
    }
    @DeleteMapping("/deletebanner")
    public Result deletebanner(String bannerId){
        Boolean bool = bannerService.removeById(bannerId);
        if(bool){
            return Result.success();
        }else {
            return Result.error("数据异常");
        }
    }
}
