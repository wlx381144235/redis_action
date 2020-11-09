package com.xizi.redis_action.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 夜尽
 * @date 2020/11/9 9:57
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientHardwareChangelogInside extends ClientHardwareChangelog {
    @TableField("`before`")
    private String before;
    @TableField("`after`")
    private String after;
}
