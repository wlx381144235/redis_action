package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.post.PostClientMapper;
import com.xizi.redis_action.mapper.post.PostClientSoftMapper;
import com.xizi.redis_action.pojo.Client;
import com.xizi.redis_action.pojo.ClientSoftware;
import com.xizi.redis_action.service.PostClientService;
import com.xizi.redis_action.service.PostClientSoftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author 夜尽
 * @date 2020年11月6日09:46:24
 */

@Service
@Slf4j
public class PostClientServiceImpl extends ServiceImpl<PostClientMapper, Client> implements PostClientService {

}
