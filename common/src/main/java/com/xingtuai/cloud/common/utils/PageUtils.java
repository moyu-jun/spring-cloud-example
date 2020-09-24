package com.xingtuai.cloud.common.utils;

import com.github.pagehelper.PageInfo;
import com.xingtuai.cloud.common.entity.PageResult;

/**
 * 分页工具类
 *
 * @author James
 * @date 2020/9/24
 */
public class PageUtils {

    public static PageResult convert(PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();

        pageResult.setPage(pageInfo.getPageNum());
        pageResult.setLimit(pageInfo.getPageSize());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setList(pageInfo.getList());

        return pageResult;
    }

}
