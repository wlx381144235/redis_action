package com.xizi.redis_action.pojo;

import lombok.Data;

/**
 * @author 夜尽
 * @date 2020/11/9 16:18
 */

@Data
public class ClientHardwareDisplaycard {
    private Integer id;
    private String mid;
    private String vendor_id;
    private String name;
    private Integer size;
    private String driver_version;
    private String driver_date;
}
