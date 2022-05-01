package com.wemoving.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wemoving.system.domain.SysUser;

import java.util.List;

/**
 * @author : liuning
 * @version 1.0
 * @description : 描述
 * @create :2022-05-01 17:08:00
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser getUserById(Integer id);

    /**
     * 列表查询
     *
     * @param user
     * @return
     */
    List<SysUser> getUserList(SysUser user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    int addUser(SysUser user);

    /**
     * 修改
     *
     * @param user
     * @return
     */
    boolean updateUser(SysUser user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


}
