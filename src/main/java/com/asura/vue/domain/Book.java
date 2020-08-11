package com.asura.vue.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/7/007 21:34
 */
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = -1187549758907033009L;

    @TableId(type = IdType.AUTO)
    private Integer bookId;

    private String bookName;

    private String author;

    private BigDecimal price;

    private LocalDateTime pressTime;

    private String press;
}
