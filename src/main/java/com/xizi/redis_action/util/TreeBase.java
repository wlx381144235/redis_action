package com.xizi.redis_action.util;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 夜尽
 * @date 2020/11/25 10:49
 */

@Data
@Accessors(chain = true)
public class TreeBase<T> {
    private Integer id;
    private Integer pid;
    private List<T> childs = new ArrayList<>();
}
