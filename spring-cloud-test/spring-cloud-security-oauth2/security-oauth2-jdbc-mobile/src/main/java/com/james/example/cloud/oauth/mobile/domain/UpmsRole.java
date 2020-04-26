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
@Table(name = "upms_role")
public class UpmsRole implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 角色备注
     */
    @Column(name = "remark")
    private String remark;

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