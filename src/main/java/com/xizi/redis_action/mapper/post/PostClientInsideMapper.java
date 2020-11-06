package com.xizi.redis_action.mapper.post;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xizi.redis_action.pojo.Client;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 夜尽
 * @date 2020年11月6日09:36:27
 */

@Mapper
@DS("postinside")
public interface PostClientInsideMapper extends BaseMapper<Client> {

}
