package com.xizi.redis_action.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 夜尽
 * @date 2020/11/6 14:23
 */

@Data
public class ClientOs {
    private Integer id;
    private String mid;
    private String name;
    private String code;
    private String lang;
    private Integer digit;
    private String kernel;
    private String version;
    private String sp;
    private Date installDate;
    private String installPath;
    private String register;
    private String regorgan;
    private Integer authcount;
    private String productId;
    private String serialNumber;
    private String osspa;
    private String pcname;
    private String loginUser;
    private String domainName;
    private Date starttime;
    private Integer runtime;
    private Date lastShutdownTime;
    private String ieVersion;
    private String outlookexpressVersion;
    private String mediaplayerVersion;
    private String iisVersion;
    private String dotnetVersion;
    private String directxVersion;
    private String kernelVersion;
}
