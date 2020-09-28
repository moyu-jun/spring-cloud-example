package com.xingtuai.cloud.nacos.discovery.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统模块-用户表
 *
 * @author James
 * @date 2020/9/25
 */
@Data
@Table(name = "sys_user")
public class SysUser implements Serializable {
    /**
     * 唯一自增ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户名（唯一）
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 手机号（唯一）
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 邮箱地址（唯一）
     */
    @Column(name = "email")
    private String email;

    /**
     * 性别（0：保密；1：男；2：女）
     */
    @Column(name = "sex")
    private Byte sex;

    /**
     * 头像地址
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 备注信息
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 是否被锁定（1：被锁定-禁用；0：未锁定-正常）
     */
    @Column(name = "locked")
    private Byte locked;

    /**
     * 是否被删除（1：被删除；0：未删除）
     */
    @Column(name = "deleted")
    private Byte deleted;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modified_time")
    private Date modifiedTime;

    private static final long serialVersionUID = 7006706222878342785L;
}