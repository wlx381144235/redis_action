package com.xizi.redis_action.mapper.post;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xizi.redis_action.pojo.ClientSoftware;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 夜尽
 * @date 2020/11/3 17:12
 */

@Mapper
@DS("postinside")
public interface PostClientSoftInsideMapper extends BaseMapper<ClientSoftware> {

}
