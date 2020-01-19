package com.wanjy.common.controller;

import com.wanjy.common.util.FileUtil;
import com.wanjy.common.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 12068
 * @date 2020/1/18  11:19
 */
@RestController
public class ImageController {
    /**
     * 多图片上传
     * @param request
     * @param name
     * @return
     */
    @RequestMapping("/imagesUpload")
    public Result imagesUpload(HttpServletRequest request, String name){
        List<String> strings = FileUtil.multiUpload(request, name);
        return Result.success(strings);
    }
}
