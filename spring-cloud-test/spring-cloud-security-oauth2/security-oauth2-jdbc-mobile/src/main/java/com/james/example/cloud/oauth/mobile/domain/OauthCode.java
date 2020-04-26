package com.james.example.cloud.oauth.mobile.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author James
 * @date 2020/4/23
 */
@Data
@Table(name = "oauth_code")
public class OauthCode implements Serializable {
    @Column(name = "code")
    private String code;

    @Column(name = "authentication")
    private byte[] authentication;

    private static final long serialVersionUID = 1L;
}