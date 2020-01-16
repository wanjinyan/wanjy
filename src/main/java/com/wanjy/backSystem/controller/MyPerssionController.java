package com.wanjy.backSystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.backSystem.Service.MyPermissionService;
import com.wanjy.common.entity.Permission;
import com.wanjy.common.service.PermissionService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class MyPerssionController {
    @Autowired private MyPermissionService myPermissionService;
    @Autowired private PermissionService permissionService;

    /**
     * 查询全部资源
     * @return
     */
    @RequestMapping("/getAllPermission")
    public Result getAllPermission(int page, int limit, String name){
        IPage<Permission> roleIPage = myPermissionService.getAllPermission(page,limit,name);
        return Result.success(roleIPage.getRecords(),(int)roleIPage.getTotal());
    }
    @RequestMapping("/getAllPermission2")
    public Result getAllPermission(){
        List<Permission> permissions = permissionService.list();
        return Result.success(permissions,permissions.size());
    }
    /**
     * 根据id删除资源
     * @param id
     * @return
     */
    @RequestMapping("/deletePermission")
    public Result deletePermission(String id){
        Boolean n = permissionService.removeById(id);
        if(n) return Result.success("删除成功");
        else return Result.error("删除失败");
    }

    /**
     * 根据role实体更新或保存资源
     * roleId有则更新，没有则新增
     * @param role
     * @return
     */
    @RequestMapping("/saveOrUpdatePermission")
    public Result saveOrUpdatePermission(Permission role){
        Boolean n = permissionService.saveOrUpdate(role);
        if(n) return Result.success("保存成功");
        else return Result.error("保存失败");
    }
}
