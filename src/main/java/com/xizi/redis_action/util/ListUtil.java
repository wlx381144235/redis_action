package com.xizi.redis_action.util;


import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 夜尽
 * @date 2020/11/4 16:30
 */

public class ListUtil<T,F> {
    
//    public static Map<String,List<ClientSoftware>> groupList(List<ClientSoftware> list){
//        //listSize为集合长度
//        int listSize=list.size();
//        //每次取1000条
//        int index=1000;
//        //用map存起来新的分组后数据
//        Map<String,List<ClientSoftware>> map = new HashMap<>();
//        for(int i = 0;i<list.size();i+=1000){
//            //作用为Index最后没有1000条数据，则剩余的条数newList中就装几条
//            if(i+1000>listSize){
//                index=listSize-i;
//            }
//            List<ClientSoftware> newList = list.subList(i,i+index);
//            //每取一次放到map集合里，然后
//            map.put("keyName"+i, newList);
//        }
//
//        return map;
//    }
//
//    public static Map<String,List<ClientSoftwareInside>> insideGroupList(List<ClientSoftware> list){
//        //listSize为集合长度
//        int listSize=list.size();
//        //每次取1000条
//        int index=1000;
//        //用map存起来新的分组后数据
//        Map<String,List<ClientSoftwareInside>> map = new HashMap<>();
//        for(int i = 0;i<list.size();i+=1000){
//            //作用为Index最后没有1000条数据，则剩余的条数newList中就装几条
//            if(i+1000>listSize){
//                index=listSize-i;
//            }
//            List<ClientSoftwareInside> insideList = new ArrayList<>();
//            list.subList(i, i + index).forEach(clientSoftware -> {
//                ClientSoftwareInside clientSoftwareInside = new ClientSoftwareInside();
//                BeanUtils.copyProperties(clientSoftware, clientSoftwareInside);
//                insideList.add(clientSoftwareInside);
//            });
//            //每取一次放到map集合里，然后
//            map.put("keyName"+i, insideList);
//        }
//
//        return map;
//    }
    
    
    public Map<String,List<T>> groupList(List<T> list){
        //listSize为集合长度
        int listSize=list.size();
        //每次取1000条
        int index=1000;
        //用map存起来新的分组后数据
        Map<String,List<T>> map = new HashMap<>();
        for(int i = 0;i<list.size();i+=1000){
            //作用为Index最后没有1000条数据，则剩余的条数newList中就装几条
            if(i+1000>listSize){
                index=listSize-i;
            }
            List<T> newList = list.subList(i,i+index);
            //每取一次放到map集合里，然后
            map.put("keyName"+i, newList);
        }
        
        return map;
    }
    
    public Map<String,List<F>> insideGroupList(List<T> list,Class<F> f){
        //listSize为集合长度
        int listSize=list.size();
        //每次取1000条
        int index=1000;
        //用map存起来新的分组后数据
        Map<String,List<F>> map = new HashMap<>();
        for(int i = 0;i<list.size();i+=1000){
            //作用为Index最后没有1000条数据，则剩余的条数newList中就装几条
            if(i+1000>listSize){
                index=listSize-i;
            }
            List<F> insideList = new ArrayList<>();
            list.subList(i, i + index).forEach(clientSoftware -> {
                F result = getFInstance(f);
                BeanUtils.copyProperties(clientSoftware, result);
                insideList.add(result);
            });
            //每取一次放到map集合里，然后
            map.put("keyName"+i, insideList);
        }

        return map;
    }
    
    /**
     * 泛型对象不能实例化，使用反射实例化
     */
    private F getFInstance(Class<F> f){
        F result = null;
        try{
            result = f.newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
