package com.james.example.cloud.oauth.mobile.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author James
 * @date 2020/4/23
 */
@Data
@Table(name = "upms_user")
public class UpmsUser implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码-密文
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 头像地址
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 性别(0：男；1：女；2：保密)
     */
    @Column(name = "sex")
    private Byte sex;

    /**
     * 激活状态(0：未激活；1：激活)
     */
    @Column(name = "activated")
    private Byte activated;

    /**
     * 锁定状态（0：锁定-禁用；1：正常）
     */
    @Column(name = "locked")
    private Byte locked;

    /**
     * 机构ID
     */
    @Column(name = "dept_id")
    private Long deptId;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 更新人
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Long updateTime;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @Column(name = "delete_flag")
    private Byte deleteFlag;

    private static final long serialVersionUID = 1L;
}