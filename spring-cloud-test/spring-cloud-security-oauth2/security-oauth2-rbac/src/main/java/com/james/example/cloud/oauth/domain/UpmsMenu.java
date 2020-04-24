package com.james.example.cloud.oauth.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * @author James
 * @date 2020/4/23
 */
@Data
@Table(name = "upms_menu")
public class UpmsMenu implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 父菜单ID，一级菜单为0
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 路径
     */
    @Column(name = "url")
    private String url;

    /**
     * 授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)
     */
    @Column(name = "permissions")
    private String permissions;

    /**
     * 类型(0: 目录, 1: 菜单, 2: 按钮)
     */
    @Column(name = "`type`")
    private Byte type;

    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 排序
     */
    @Column(name = "orders")
    private Integer orders;

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