package com.wanjy.backSystem.entity;

import com.baomidou.mybatisplus.extension.service.IService;
import lombok.Data;

/**
 * @author 12068
 * @date 2020/2/17  21:19
 */
@Data
public class MyTotal {
    private String title;
    private int total;
    private String updateTime;
}
