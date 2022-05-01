package com.wemoving.web.controller.system;

import com.wemoving.common.core.controller.BaseController;
import com.wemoving.common.core.domain.Result;
import com.wemoving.common.core.page.PageResult;
import com.wemoving.system.domain.SysUser;
import com.wemoving.system.service.SysUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : liuning
 * @version 1.0
 * @description : 描述
 * @create :2022-05-01 18:59:00
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {

    @Resource
    private SysUserService userService;

    /**
     * 获取用户列表
     */
    @GetMapping("/list")
    public PageResult list(SysUser user) {
        startPage();
        List<SysUser> list = userService.getUserList(user);
        return buildPageResult(list);
    }

    /**
     * 通过ID获取用户
     */
    @GetMapping("/{userId}")
    public Result getUserById(@PathVariable Integer userId) {
        SysUser userById = userService.getUserById(userId);
        return Result.success(userById);
    }


    /**
     * 新增用户
     */
    @PostMapping
    public Result add(@Validated @RequestBody SysUser user) {
        return Result.success(userService.addUser(user));
    }

    /**
     * 修改用户
     */
    @PutMapping
    public Result edit(@Validated @RequestBody SysUser user) {
        return Result.success(userService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{userId}")
    public Result remove(@PathVariable Integer userId) {
        return toResult(userService.deleteById(userId));
    }

}
