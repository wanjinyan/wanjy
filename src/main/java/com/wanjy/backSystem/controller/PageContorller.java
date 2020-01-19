package com.wanjy.backSystem.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 页面控制层 负责页面跳转
 */
@Controller
public class PageContorller {
    @GetMapping("/")
    public ModelAndView login1(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/login-2.html");
        return modelAndView;
    }


    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/login-2.html");
        return modelAndView;
    }

    @GetMapping("/menu")
    public ModelAndView menu(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/menu.html");
        return modelAndView;
    }

    @GetMapping("/role")
    public ModelAndView role(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/role.html");
        return modelAndView;
    }
    @GetMapping("/permission")
    public ModelAndView perssion(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/permission.html");
        return modelAndView;
    }

    @GetMapping("/rolepermission")  //授权管理的地址
    public ModelAndView roleperssion(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/rolepermission.html");
        return modelAndView;
    }

    @GetMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/index.html");
        return modelAndView;
    }

    @GetMapping("/welcome")
    public ModelAndView welcome(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/welcome-1.html");
        return modelAndView;
    }

    @GetMapping(value = "/notRole")
    public ModelAndView notRole(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/404.html");
        return modelAndView;
    }
    @GetMapping(value = "/signup")
    public ModelAndView signUp(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/sign_up.html");
        return modelAndView;
    }

    @GetMapping("/userInfo")
    public ModelAndView userInfo(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/user_info.html");
        return modelAndView;
    }
    @GetMapping("/shopInfo")
    public ModelAndView shopInfo(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/shop_store_info.html");
        return modelAndView;
    }
    @GetMapping("/addshop")
    public ModelAndView addshop(HttpServletRequest request,String shopStoreId){
        Map map =new HashMap();
        if(shopStoreId !=null && !shopStoreId.equals("")){
            map.put("shopStoreId",shopStoreId);
        }
        else {
            map.put("shopStoreId","");
        }
        return new ModelAndView("back-system/page/addshop.html",map);
    }
}
