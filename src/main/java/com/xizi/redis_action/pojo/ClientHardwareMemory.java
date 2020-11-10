package com.xizi.redis_action.pojo;

import lombok.Data;

/**
 * @author 夜尽
 * @date 2020/11/10 9:33
 */

@Data
public class ClientHardwareMemory {
    private Integer id;
    private String mid;
    private String vendor_id;
    private String name;
    private Integer size;
    private String formfactor;
    private String serial_number;
    private String type;
    private String release_date;
}
