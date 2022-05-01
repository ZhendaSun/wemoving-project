package com.wemoving.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wemoving.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * @author : liuning
 * @version 1.0
 * @description : 用户类
 * @create :2022-05-01 17:08:00
 */
@Data
@TableName("sys_user")
public class SysUser extends BaseEntity {

    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private String nickName;

    /**
     *
     */
    private String userType;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String phonenumber;

    /**
     *
     */
    private String sex;

    /**
     *
     */
    private String avatar;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String status;

    /**
     *
     */
    private String delFlag;

    /**
     *
     */
    private String loginIp;

    /**
     *
     */
    private String loginDate;

}
