package com.james.example.cloud.oauth.mobile.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author James
 * @date 2020/4/23
 */
@Data
@Table(name = "oauth_approvals")
public class OauthApprovals implements Serializable {
    @Column(name = "userId")
    private String userid;

    @Column(name = "clientId")
    private String clientid;

    @Column(name = "`scope`")
    private String scope;

    @Column(name = "`status`")
    private String status;

    @Column(name = "expiresAt")
    private Date expiresat;

    @Column(name = "lastModifiedAt")
    private Date lastmodifiedat;

    private static final long serialVersionUID = 1L;
}