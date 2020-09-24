package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自定义 Mapper
 * 特别注意，该接口不能被扫描到，否则会报错
 *
 * @author James
 * @date 2020/9/24
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}