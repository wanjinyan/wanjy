package com.wanjy.shrio;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wanjy.common.entity.ActiveUser;
import com.wanjy.common.entity.Role;
import com.wanjy.common.entity.User;
import com.wanjy.common.service.RoleService;
import com.wanjy.common.service.UserService;
import com.wanjy.common.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述：权限验证规则
 * @author wanjy
 * @create 2019-12-27-13:57
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired private UserService userService;
    @Autowired private RoleService roleService;
    /**
     * 资源授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("-------资源授权--------");
        ActiveUser activeUser = (ActiveUser) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        //这里给用户配置权限
        stringSet.add(activeUser.getRole());
        System.out.println("当前用户权限:" + activeUser.getRole());
        info.setRoles(stringSet);
        return info;
    }

    /**
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证--------");
        /**
         * 从Token中获取UserController传过来的账户信息
         */
        String user_account = (String) authenticationToken.getPrincipal();//获取用户账号
        User user= null;
        /**
         * 从数据库获取用户数据
         */
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("account",user_account);
            user = userService.getOne(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 判断用户数据是否存在
         */
        if (user==null) {
            System.out.println("用户名不正确或用户不存在!");
            return null;
        }
        /**
         * 获取用户角色数据
         */
        Role role = new Role();
        try {
            role = roleService.getById(user.getRoleId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String password = user.getPassword(); //数据库获取到的用户密码
        String salt = user.getSalt();   //从数据库获取的加密盐
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUser_id(user.getUserId());
        activeUser.setAccount(user.getAccount());
        activeUser.setNickname(user.getNickname());
        activeUser.setRole(role.getRoleFlag());
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                activeUser, password, ByteSource.Util.bytes(salt), this.getName());
        return simpleAuthenticationInfo;

    }
}
