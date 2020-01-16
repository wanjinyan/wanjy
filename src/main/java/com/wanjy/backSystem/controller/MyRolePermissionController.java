package com.wanjy.backSystem.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.backSystem.Service.MyRolePermissionService;
import com.wanjy.backSystem.entity.MyRolePermission;
import com.wanjy.common.entity.RolePermission;
import com.wanjy.common.service.RolePermissionService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 授权资源控制层接口
 */
@RestController //声明它是controller(控制层) 返回的是ResponseBody 相当于@Controller +  @ResponseBody的组合
@RequestMapping("/rolepermission") //用来请求的顶级路径
public class MyRolePermissionController {
    @Autowired private RolePermissionService rolePermissionService; //mybatis生成的服务层接口
    @Autowired private MyRolePermissionService myRolePermissionService;//自定义的服务层接口

    /**
     * 查询全部授权资源
     * @return
     */
    @RequestMapping("/getAllRolePermission")
    public Result getAllRolePermission(int page, int limit, String roleName, String permissionName){
        IPage<MyRolePermission> RolePermissionIPage = myRolePermissionService.getAllRolePermission(page,limit,roleName,permissionName);
        return Result.success(RolePermissionIPage.getRecords(),(int)RolePermissionIPage.getTotal());
    }

    /**
     * 根据id删除授权资源
     * @param id
     * @return
     */
    @RequestMapping("/deleteRolePermission")
    public Result deleteRolePermission(String id){
        Boolean n = rolePermissionService.removeById(id);
        if(n) return Result.success("删除成功");
        else return Result.error("删除失败");
    }

    /**
     * 根据RolePermission实体更新或保存授权资源
     * RolePermissionId有则更新，没有则新增
     * @param RolePermission
     * @return
     */
    @RequestMapping("/saveOrUpdateRolePermission")
    public Result saveOrUpdateRolePermission(RolePermission RolePermission){
        Boolean n = rolePermissionService.saveOrUpdate(RolePermission);
        if(n) return Result.success("保存成功");
        else return Result.error("保存失败");
    }
}
