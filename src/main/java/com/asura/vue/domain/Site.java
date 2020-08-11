package com.asura.vue.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/8/008 10:03
 */
@Data
@ToString
@TableName("site")
public class Site implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String personName; //人名称
    private String sortSite;   //随机生成的位置号
    private int ahead;    //是否是前四
}
