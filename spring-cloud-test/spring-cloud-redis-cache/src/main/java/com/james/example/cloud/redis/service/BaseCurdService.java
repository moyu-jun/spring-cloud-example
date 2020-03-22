package com.james.example.cloud.redis.service;

import java.util.List;

/**
 * 通用 CURD 接口
 *
 * Created by James on 2020/3/7.
 */
public interface BaseCurdService<T> {

    /**
     * 新建操作
     *
     * @param record    操作对象
     * @return {@code int} 大于 0 则表示添加成功
     */
    int insert(T record);

    /**
     * 删除对象
     *
     * @param id    主键 ID
     * @return {@code int} 大于 0 则表示删除成功
     */
    int delete(Integer id);

    /**
     * 批量删除对象
     *
     * @param records   对象集合
     * @return {@code int} 大于 0 则表示删除成功
     */
    int delete(List<T> records);

    /**
     * 更新操作
     *
     * @param record    操作对象
     * @return {@code int} 大于 0 则表示添加成功
     */
    int update(T record);

    /**
     * 获取单体信息
     *
     * @param id    主键 ID
     * @return {@link T}
     */
    T select(Integer id);

    /**
     * 获取单体信息
     *
     * @param record    操作对象
     * @return {@link T}
     */
    T select(T record);

    /**
     * 获取全部列表
     *
     * @param label    过滤参数
     * @return {@link List <UpmsUser>} 所有用户列表
     */
    List<T> selectAll(String label);

}
