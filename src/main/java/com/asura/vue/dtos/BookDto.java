package com.asura.vue.dtos;

import com.asura.vue.domain.Book;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/7/007 21:40
 */
@Data
public class BookDto extends Book {
    private Integer pageNum;
    private Integer pageSize;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
