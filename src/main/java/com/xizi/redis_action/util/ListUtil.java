package com.xizi.redis_action.util;

import com.xizi.redis_action.pojo.ClientSoftware;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 夜尽
 * @date 2020/11/4 16:30
 */

public class ListUtil {
    
    public static Map<String,List<ClientSoftware>> groupList(List<ClientSoftware> list){
        //listSize为集合长度
        int listSize=list.size();
        //每次取1000条
        int index=1000;
        //用map存起来新的分组后数据
        Map<String,List<ClientSoftware>> map = new HashMap<>();
        for(int i = 0;i<list.size();i+=1000){
            //作用为Index最后没有1000条数据，则剩余的条数newList中就装几条
            if(i+1000>listSize){
                index=listSize-i;
            }
            List<ClientSoftware> newList = list.subList(i,i+index);
            //每取一次放到map集合里，然后
            map.put("keyName"+i, newList);
        }
        
        return map;
    }
    
}
