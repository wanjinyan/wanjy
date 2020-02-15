package com.wanjy.backSystem.controller;

import com.wanjy.common.entity.ActiveUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 页面控制层 负责页面跳转
 */
@Controller
public class PageContorller {
    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request){
        return new ModelAndView("fronts/index.html");
    }
    @GetMapping("/cart")
    public ModelAndView cart(HttpServletRequest request){
        return new ModelAndView("fronts/cart.html");
    }
    @GetMapping("/product")
    public ModelAndView product(String goodsId){
        Map map = new HashMap();
        map.put("goodsId",goodsId);
        return new ModelAndView("fronts/product.html",map);
    }
    @GetMapping("/products")
    public ModelAndView products(HttpServletRequest request){
        return new ModelAndView("fronts/products.html");
    }
    @GetMapping("/head")
    public ModelAndView head(HttpServletRequest request){
        ActiveUser activeUser = (ActiveUser)request.getSession().getAttribute("activeUser");
        Map map =new HashMap();
        if(activeUser!=null){
            map.put("username",activeUser.getNickname());
        }
        return new ModelAndView("fronts/head.html",map);
    }
    @GetMapping("/foot")
    public ModelAndView foot(HttpServletRequest request){
        return new ModelAndView("fronts/foot.html");
    }
    @GetMapping("/index")
    public ModelAndView index2(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject(); //获取登录凭证
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal(); //获取登录信息
        request.getSession().setAttribute("activeUser", activeUser);//将登录信息放到session
        if(activeUser==null || activeUser.getRole().equals("user:user"))//如果是用户登录往首页跳转
        {
            return index(request);
        }
        else //如果是管理员和商家登录往后台跳转
        {
            return backindex(request);
        }
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

    @GetMapping("/backindex")
    public ModelAndView backindex(HttpServletRequest request){
        ActiveUser activeUser = (ActiveUser)request.getSession().getAttribute("activeUser");
        Map map =new HashMap();
        map.put("username",activeUser.getNickname());
        return new ModelAndView("back-system/backindex.html",map);
    }

    @GetMapping("/welcome")
    public ModelAndView welcome(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/welcome-1.html");
        return modelAndView;
    }
    @GetMapping("/shopwelcome")
    public ModelAndView shopwelcome(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/welcome-2.html");
        return modelAndView;
    }

    @GetMapping(value = "/notRole")
    public ModelAndView notRole(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/404.html");
        return modelAndView;
    }
    @GetMapping(value = "/viewbanner")
    public ModelAndView viewBanner(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/viewbanner.html");
        return modelAndView;
    }
    @GetMapping(value = "/addbanner")
    public ModelAndView addBanner(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("back-system/page/addbanner.html");
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

    @GetMapping("/goodsInfo")
    public ModelAndView goodsInfo(HttpServletRequest request){
        return new ModelAndView("back-system/page/goodsInfo.html");
    }
    @GetMapping("/addgoods")
    public ModelAndView addgoods(HttpServletRequest request){
        return new ModelAndView("back-system/page/addgoods.html");
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request,HttpServletResponse response) {
        Subject lvSubject=SecurityUtils.getSubject();
        lvSubject.logout();
        response.setStatus(302);
        request.getSession().removeAttribute("activeUser");
        login(request);
    }

}
