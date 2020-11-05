package com.xizi.redis_action.mapper.mysql;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xizi.redis_action.pojo.ClientSoftwareInside;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 夜尽
 * @date 2020/11/3 17:12
 */

@Mapper
@DS("my")
public interface MysqlClientInsideMapper extends BaseMapper<ClientSoftwareInside> {

}
