package com.xizi.redis_action.mapper.mysql;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xizi.redis_action.pojo.ClientNetworkAdapters;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 夜尽
 * @date 2020年11月6日09:34:32
 */

@Mapper
@DS("my")
public interface MysqlClientNetworkAdapterMapper extends BaseMapper<ClientNetworkAdapters> {

}
