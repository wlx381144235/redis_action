package com.xizi.redis_action.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author 夜尽
 * @date 2020/11/9 9:57
 */

@Data
@TableName("client_hardware_changelog")
public class PostClientHardwareChangelog {
    private Integer id;
    private String mid;
    private Integer change_type;
    private Date change_date;
    private String before;
    private String after;
    private Integer content;
    private Integer status;
    private String memo;
    private Date ack_time;
    private Integer ack_user;
}
