package com.james.example.cloud.oauth.mobile.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author James
 * @date 2020/4/23
 */
@Data
@Table(name = "clientdetails")
public class Clientdetails implements Serializable {
    @Id
    @Column(name = "appId")
    private String appid;

    @Column(name = "resourceIds")
    private String resourceids;

    @Column(name = "appSecret")
    private String appsecret;

    @Column(name = "`scope`")
    private String scope;

    @Column(name = "grantTypes")
    private String granttypes;

    @Column(name = "redirectUrl")
    private String redirecturl;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;

    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;

    @Column(name = "additionalInformation")
    private String additionalinformation;

    @Column(name = "autoApproveScopes")
    private String autoapprovescopes;

    private static final long serialVersionUID = 1L;
}