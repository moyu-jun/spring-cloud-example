package com.james.example.rabbit.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author James
 * @date 2020/6/1
 */
@Data
@EqualsAndHashCode
@ToString
public class SystemLog implements Serializable {

    private static final long serialVersionUID = 2242061547145412354L;
    
    private Long id;
    private String username;
    private String message;
    private LocalDateTime createTime;
}
