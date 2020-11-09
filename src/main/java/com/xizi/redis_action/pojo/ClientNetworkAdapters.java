package com.xizi.redis_action.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 夜尽
 * @date 2020/11/9 9:16
 */

@Data
public class ClientNetworkAdapters {
    private Integer id;
    private String mid;
    private Integer status;
    private Integer binding_conf;
    private Integer forbid_mac;
    private String guid;
    private String name;
    private String adapter;
    private String mac;
    private Integer is_static;
    private String ip_addr;
    private String gateway;
    private Integer is_dns;
    private String dns;
    private String vendor_id;
    private String model;
    private String config_bind;
    private String subnet;
    private Integer is_connected;
    private Date modify_time;
}
