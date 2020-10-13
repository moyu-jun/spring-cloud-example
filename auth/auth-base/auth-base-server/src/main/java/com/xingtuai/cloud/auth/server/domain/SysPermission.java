package com.xingtuai.cloud.auth.server.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统模块-权限表
 *
 * @author James
 * @date 2020/10/10
 */
@Data
@Table(name = "sys_permission")
public class SysPermission implements Serializable {
    /**
     * 唯一自增ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 权限名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 父ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 所属产品ID
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 类型（0: 目录, 1: 菜单, 2: 按钮）
     */
    @Column(name = "`type`")
    private Byte type;

    /**
     * 授权（多个用逗号分隔，如：sys:user:add,sys:user:edit）
     */
    @Column(name = "permissions")
    private String permissions;

    /**
     * URL路径
     */
    @Column(name = "url")
    private String url;

    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

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

    private static final long serialVersionUID = 1L;
}