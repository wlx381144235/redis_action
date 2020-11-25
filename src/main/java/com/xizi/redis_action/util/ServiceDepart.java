package com.xizi.redis_action.util;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 夜尽
 * @date 2020/11/25 10:55
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class ServiceDepart extends TreeBase<ServiceDepart> {
    private Integer level;
    private String parentName;
    private String departName;
}
