package com.xizi.redis_action.pojo;

import lombok.Data;

/**
 * @author 夜尽
 * @date 2020/11/6 15:57
 */

@Data
public class ClientNic {
    private Integer id;
    private String mid;
    private String mac;
    private Integer type;
}
