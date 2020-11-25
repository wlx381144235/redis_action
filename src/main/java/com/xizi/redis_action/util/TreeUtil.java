package com.xizi.redis_action.util;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 夜尽
 * @date 2020/11/25 10:47
 */

public class TreeUtil<T extends TreeBase<T>> {
    
    private void constructTree(T T, List<T> list){
        Iterator<T> iterator = list.iterator();
        List<T> childs = new ArrayList<>();
        while (iterator.hasNext()){
            T TChild = iterator.next();
            if(TChild.getPid().equals(T.getId())){
                childs.add(TChild);
                iterator.remove();
            }
        }
        if (!CollectionUtils.isEmpty(childs)) {
            T.setChilds(childs);
        }
        if (!CollectionUtils.isEmpty(list) && !childs.isEmpty()) {
            childs.forEach(node -> constructTree(node, list));
        }
    }
    
    public static void main(String[] args) {
        ServiceDepart serviceDepart1 = new ServiceDepart();
        serviceDepart1.setId(1).setPid(0).setChilds(new ArrayList<>());
        serviceDepart1.setDepartName("总社").setParentName("无");
        ServiceDepart serviceDepart2 = new ServiceDepart();
        serviceDepart2.setId(3).setPid(1).setChilds(new ArrayList<>());
        serviceDepart2.setDepartName("总编室").setParentName("总社");
        ServiceDepart serviceDepart3 = new ServiceDepart();
        serviceDepart3.setId(5).setPid(3).setChilds(new ArrayList<>());
        serviceDepart3.setDepartName("国内新闻编辑部").setParentName("总编室");
        List<ServiceDepart> list = new ArrayList<>();
        list.add(serviceDepart2);
        list.add(serviceDepart3);
        TreeUtil<ServiceDepart> treeUtil = new TreeUtil<>();
        treeUtil.constructTree(serviceDepart1,list);
        System.out.println(serviceDepart1);
        System.out.println("==========");
    }
}
