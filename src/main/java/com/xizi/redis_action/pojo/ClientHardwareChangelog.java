package com.xizi.redis_action.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author 夜尽
 * @date 2020/11/9 9:57
 */

@Data
public class ClientHardwareChangelog {
    private Integer id;
    private String mid;
    private Integer change_type;
    private Date change_date;
    @TableField("`before`")
    private String before;
    @TableField("`after`")
    private String after;
    private Integer content;
    private Integer status;
    private String memo;
    private Date ack_time;
    private Integer ack_user;
}
