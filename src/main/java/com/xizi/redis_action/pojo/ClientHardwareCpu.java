package com.xizi.redis_action.pojo;

import lombok.Data;

/**
 * @author 夜尽
 * @date 2020/11/9 15:49
 */

@Data
public class ClientHardwareCpu {
    private Integer id;
    private String mid;
    private String name;
    private String model;
    private String vendor_id;
    private String processor_version;
    private String serial_number;
    private String max_speed;
    private String current_speed;
    private Integer szexternal;
    private Integer szrmutipler;
    private Integer core_count;
    private Integer nthreadnum;
    private Double frequency;
    private Integer support_vpro;
}
