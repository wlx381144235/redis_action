package com.xizi.redis_action.pojo;

import lombok.Data;

/**
 * @author 夜尽
 * @date 2020/11/10 9:50
 */

@Data
public class ClientHardwareMonitor {
    private Integer id;
    private String mid;
    private String vendor_id;
    private String model;
    private String firmware_date;
    private Double screen_size;
    private String serial_number;
    private String screen_ratio;
    private String resolution;
}
