package com.xizi.redis_action.pojo;

import lombok.Data;

/**
 * @author 夜尽
 * @date 2020/11/9 17:06
 */

@Data
public class ClientHardwareMainboard {
    private Integer id;
    private String mid;
    private String name;
    private String vendor_id;
    private String version;
    private String type;
    private String serial_number;
    private String chipset;
    private String bios_name;
    private String bios_version;
    private String bios_releasedate;
    private String bios_size;
}
