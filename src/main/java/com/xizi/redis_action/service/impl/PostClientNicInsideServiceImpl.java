package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.post.PostClientAllInsideMapper;
import com.xizi.redis_action.mapper.post.PostClientNicInsideMapper;
import com.xizi.redis_action.pojo.ClientAll;
import com.xizi.redis_action.pojo.ClientNic;
import com.xizi.redis_action.service.PostClientAllInsideService;
import com.xizi.redis_action.service.PostClientNicInsideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author 夜尽
 * @date 2020年11月6日09:47:20
 */

@Service
@Slf4j
public class PostClientNicInsideServiceImpl extends ServiceImpl<PostClientNicInsideMapper, ClientNic> implements PostClientNicInsideService {

}
