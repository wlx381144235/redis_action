package com.xizi.redis_action.mapper.post;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xizi.redis_action.pojo.ClientHardwareNetadapter;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 夜尽
 * @date 2020年11月6日09:36:07
 */

@Mapper
@DS("post")
public interface PostClientHardwareNetadapterMapper extends BaseMapper<ClientHardwareNetadapter> {

}
