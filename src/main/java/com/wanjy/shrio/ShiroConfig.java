package com.wanjy.shrio;

import com.wanjy.backSystem.Service.MyRolePermissionService;
import com.wanjy.backSystem.entity.MyRolePermission;
import com.wanjy.common.entity.Role;
import com.wanjy.common.service.RolePermissionService;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：shrio权限控制
 *
 * @create 2019-01-27-13:38
 */
@Configuration
public class ShiroConfig {

    @Autowired private RolePermissionService rolePermissionService;

    /**
     * 常用过滤器
     * anon 允许匿名访问
     * authc 必须通过认证
     * user 如果使用rememberme可与访问
     * perms 该资源必须要有资源权限才可以访问
     * role 该资源必须得到角色权限才可以访问
     *
     * @param securityManager
     * @return
     */
    //权限设置
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login"); //设置登录的访问页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole"); //设置没有权限的访问请求
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        filterChainDefinitionMap.put("/user/login", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/index", "anon");
        filterChainDefinitionMap.put("/head", "anon");
        filterChainDefinitionMap.put("/foot", "anon");
        filterChainDefinitionMap.put("/product", "anon");
        filterChainDefinitionMap.put("/products", "anon");
        filterChainDefinitionMap.put("/user/addUser", "anon");
        filterChainDefinitionMap.put("/signup", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/api/**","anon");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/images/**","anon");
        filterChainDefinitionMap.put("/lib/**","anon");
        filterChainDefinitionMap.put("/photo/**", "anon");
        filterChainDefinitionMap.put("/plugin/**","anon");
        filterChainDefinitionMap.put("/banner/getbanner","anon");
        filterChainDefinitionMap.put("/goods/getGoodsInfo","anon");
        filterChainDefinitionMap.put("/menu/getShowMenu","anon");
        filterChainDefinitionMap.put("/shopcar/getShopCarTotal","anon");
        filterChainDefinitionMap.put("/goods/getGoodsInfoBygoodsId","anon");
        //这里去从数据库动态配置权限
        List<MyRolePermission> rolePermissionList = rolePermissionService.getAllRolePermission();
        for (MyRolePermission myRolePermission : rolePermissionList) {
            filterChainDefinitionMap.put(myRolePermission.getPermissionUrl(), "roles[" + myRolePermission.getRoleFlag() + "]");
            System.out.println("权限路径:" + myRolePermission.getPermissionUrl() + " 角色信息:roles[" + myRolePermission.getRoleFlag() + "]");
        }
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
        filterChainDefinitionMap.put("/**", "authc"); //authc
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(customRealm());
        return defaultSecurityManager;
    }

    @Bean
    public CustomRealm customRealm() {
        CustomRealm customRealm = new CustomRealm();
        // 告诉realm,使用credentialsMatcher加密算法类来验证密文
        customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        customRealm.setCachingEnabled(false);
        return customRealm;
    }


    /**
     * *
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * *
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(1);
        // storedCredentialsHexEncoded默认是true，此时用的是密码加密用的是Hex编码；false时用Base64编码
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }
}
