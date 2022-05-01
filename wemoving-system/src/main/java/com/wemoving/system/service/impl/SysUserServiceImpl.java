package com.wemoving.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wemoving.system.domain.SysUser;
import com.wemoving.system.mapper.SysUserMapper;
import com.wemoving.system.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : liuning
 * @version 1.0
 * @description : 描述
 * @create :2022-05-01 17:09:00
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserById(Integer id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public List<SysUser> getUserList(SysUser user) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        return sysUserMapper.selectList(queryWrapper);
    }

    @Override
    public int addUser(SysUser user) {
        return sysUserMapper.insert(user);
    }

    @Override
    public boolean updateUser(SysUser user) {
        return sysUserMapper.updateById(user) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return sysUserMapper.deleteById(id) > 0;
    }

}
