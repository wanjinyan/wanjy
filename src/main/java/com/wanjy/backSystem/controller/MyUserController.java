package com.wanjy.backSystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanjy.backSystem.entity.MyUserDetails;
import com.wanjy.common.entity.ActiveUser;
import com.wanjy.common.entity.User;
import com.wanjy.common.service.UserDetailsService;
import com.wanjy.common.service.UserService;
import com.wanjy.common.util.GenstrUtil;
import com.wanjy.common.util.MD5;
import com.wanjy.common.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class MyUserController {
    @Autowired private UserService userService;
    @Autowired private UserDetailsService userDetailsService;

    /**
     *注册
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addUser")
    public Result addUser(User user) throws Exception {
        List<User> userList = new ArrayList<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",user.getAccount());
        userList=userService.list(queryWrapper);
        if(userList.size()>0){
            return Result.error("用户名已经存在，请重新输入！");
        }else {
            String salt = GenstrUtil.generateString(4);
            user.setRoleId("2");
            user.setSalt(salt);
            user.setPassword(MD5.md5Password(user.getPassword(), salt, 1));
            user.setRegisterTime(new Date());
            boolean n = userService.save(user);
            if (n) return Result.success("注册成功");
            else return Result.error("注册失败");
        }
    }

    /**
     *登录
     * @param account
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Result login(String account,String password) {
        Result result = null;
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            result = Result.error("未知账户");
        } catch (IncorrectCredentialsException ice) {
            result = Result.error("密码不正确");
        } catch (LockedAccountException lae) {
            result = Result.error("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            result = Result.error("用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            result = Result.error("用户名或密码不正确");
        }
        if (subject.isAuthenticated()) {
            result = Result.success(account, "登录成功");
        } else {
            token.clear();
        }
        return result;
    }

    @GetMapping("/getAllUserInfo")
    public Result getAllUserInfo(int page, int limit, String nickname){
        IPage<User> userIPage = new Page<>(page, limit);
        if(nickname != null && !nickname.equals("")){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("nickname",nickname);
            userIPage = userService.page(userIPage,queryWrapper);
        }else {
            userIPage = userService.page(userIPage);
        }
        return Result.success(userIPage.getRecords(),(int) userIPage.getTotal());
    }

    @GetMapping("/getAllUser")
    public Result getAllUser(){
        List<User> users = userService.list();
        if(users!=null)return Result.success(users,users.size());
        else return Result.error("获取数据失败");
    }

    @PostMapping("/editPassword")
    public Result editPassword(HttpServletRequest request,String oldPassword,String newPassword){
        ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
        String userId = activeUser.getUser_id();
        User user = userService.getById(userId);
        oldPassword = MD5.md5Password(oldPassword,user.getSalt(),1);
        if(user.getPassword().equals(oldPassword)){
            newPassword = MD5.md5Password(newPassword,user.getSalt(),1);
            user.setPassword(newPassword);
            return saveOrUpdateUser(user);
        }else {
            return Result.error("密码错误");
        }
    }
    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    @PostMapping("/saveOrUpdateUser")
    public Result saveOrUpdateUser(User user){
        Boolean n = userService.saveOrUpdate(user);
        if(n) return Result.success("编辑成功");
        else return Result.error("编辑失败");
    }
    /**
     * 根据userId查询用户详情
     * @param userId
     * @return
     */
    @GetMapping("/getUserDetails")
    public Result getUserDetails(HttpServletRequest request,String userId){
        if (userId == null || userId.equals("")){
            ActiveUser activeUser =(ActiveUser) request.getSession().getAttribute("activeUser");
            userId = activeUser.getUser_id();
        }
        QueryWrapper<MyUserDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user.user_id",userId);
        MyUserDetails myUserDetails = userDetailsService.getUserDetails(queryWrapper);
        if(myUserDetails != null)
            return Result.success(myUserDetails);
        else return Result.error("数据异常");
    }
}
