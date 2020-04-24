package com.james.example.cloud.oauth.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * @author James
 * @date 2020/4/23
 */
@Data
@Table(name = "upms_user_menu")
public class UpmsUserMenu implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 权限编号
     */
    @Column(name = "menu_id")
    private Long menuId;

    /**
     * 权限类型(-1:减权限,1:增权限)
     */
    @Column(name = "`type`")
    private Byte type;

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

    private static final long serialVersionUID = 1L;
}