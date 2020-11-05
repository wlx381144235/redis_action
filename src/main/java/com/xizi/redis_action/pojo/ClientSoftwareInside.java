package com.xizi.redis_action.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 夜尽
 * @date 2020/11/3 17:07
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientSoftwareInside extends ClientSoftware implements Serializable {

    @TableId
    private Long id;
    

}
