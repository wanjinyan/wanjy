/**
 * Copyright (C), 2019-2020, sumeng
 * FileName: HttpUtils
 * Author: sumeng
 * Date: 2020/5/15 9:22
 */
package com.wanjy.common.util;/**
 * @ClassName: HttpUtils
 * @Description:
 * @Author: sumeng
 * @Version: 1.0.0
 * @Date: 2020/5/15 9:22
 */

import com.wanjy.common.entity.ActiveUser;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 * @date 2020/5/15  9:22
 * @author 12068
 */
public class HttpUtils {
    public static String getUserId(HttpServletRequest request){
        ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
        String userId=null;
        if (activeUser!=null){
            userId= activeUser.getUser_id();
        }
        return userId;
    }
}
