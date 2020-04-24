package com.james.example.cloud.oauth.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

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