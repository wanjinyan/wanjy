package com.wanjy.backSystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanjy.backSystem.Service.MyRoleService;
import com.wanjy.common.entity.Role;
import com.wanjy.common.service.RoleService;
import com.wanjy.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/role")
public class MyRoleController {
    @Autowired private RoleService roleService;
    @Autowired private MyRoleService myroleService;

    /**
     * 查询全部角色
     * @return
     */
    @RequestMapping("/getAllRole")
    public Result getAllRole(int page,int limit,String name){
        IPage<Role> roleIPage = myroleService.getAllRole(page,limit,name);
        return Result.success(roleIPage.getRecords(),(int)roleIPage.getTotal());
    }
    /**
     * 查询全部角色
     * @return
     */
    @RequestMapping("/getAllRole2")
    public Result getAllRole(){
        List<Role> roles = roleService.list();
        return Result.success(roles,roles.size());
    }

    /**
     * 根据ID查询角色
     * @param roleId
     * @return
     */
    @GetMapping("/roleIdToName")
    public Result roleIdToName(String roleId){
        Role role = roleService.getById(roleId);
        if(role != null) return Result.success(role);
        else return Result.error();
    }
    /**
     * 根据id删除角色
     * @param id
     * @return
     */
    @RequestMapping("/deleteRole")
    public Result deleteRole(String id){
        Boolean n = roleService.removeById(id);
        if(n) return Result.success("删除成功");
        else return Result.error("删除失败");
    }

    /**
     * 根据role实体更新或保存角色
     * roleId有则更新，没有则新增
     * @param role
     * @return
     */
    @RequestMapping("/saveOrUpdateRole")
    public Result saveOrUpdateRole(Role role){
        Boolean n = roleService.saveOrUpdate(role);
        if(n) return Result.success("保存成功");
        else return Result.error("保存失败");
    }

}
