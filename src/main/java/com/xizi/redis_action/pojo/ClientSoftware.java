package com.xizi.redis_action.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 夜尽
 * @date 2020/11/3 17:07
 */

@Data
public class ClientSoftware implements Serializable {

    @TableId
    private Long id;
    
    private String mid;
    
    private String name;
    
    private String installPath;
    
    private String installDate;
    
    private double disksize;
    
    private String version;
    
    private String company;
    
    private String uninscmdline;
    
    private String description;
    
    private String serialNumber;
    
    private Long sid;
    
    private Long softId;
    
    private Long softFrom;
    
    private String softmgrVersion;

}
