package com.xizi.redis_action.pojo;

import lombok.Data;

/**
 * @author 夜尽
 * @date 2020/11/9 16:29
 */

@Data
public class ClientHardwareHarddisk {
    private Integer id;
    private String mid;
    private String serial_number;
    private String vendor_id;
    private String name;
    private String type;
    private Integer speed;
    private Integer cache;
    private Integer elapsed_time;
    private String description;
    private String interface_type;
    private Integer transmission_rate;
    private Integer size;
    private String partations;
}
