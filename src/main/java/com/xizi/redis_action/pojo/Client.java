package com.xizi.redis_action.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 夜尽
 * @date 2020/11/6 9:22
 */

@Data
public class Client {
    private Integer id;
    private String mid;
    private String ip;
    private String reportIp;
    private String name;
    private String domain;
    private String mac;
    private Integer gid;
    private String nickname;
    private String workGroup;
    private String sdEngine;
    private String ieVer;
    private Integer sysSpace;
    private String os;
    private Integer osBit;
    private Integer isDeploy;
    private String loginUser;
    private Date lastTime;
    private Date firstTime;
    private String displayName;
    private Integer isOnline;
    private Integer type;
    private Integer isVirtual;
    private Integer isInstall;
    private Date changeTime;
}
