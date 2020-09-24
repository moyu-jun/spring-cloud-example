package com.xingtuai.cloud.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果实体类
 *
 * @author James
 * @date 2020/9/24
 */
@Data
@EqualsAndHashCode
@ToString
public class PageResult implements Serializable {

    private static final long serialVersionUID = -1623108289350079338L;

    /**
     * 当前页码
     */
    private int page;

    /**
     * 每页数量
     */
    private int limit;

    /**
     * 记录总数
     */
    private long totalSize;

    /**
     * 页码总数
     */
    private int totalPages;

    /**
     * 分页数据
     */
    private List<?> list;
}
