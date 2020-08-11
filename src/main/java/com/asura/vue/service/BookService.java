package com.asura.vue.service;

import com.asura.vue.domain.Book;
import com.asura.vue.domain.PageResult;
import com.asura.vue.domain.Result;
import com.asura.vue.dtos.BookDto;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/7/007 21:34
 */
public interface BookService {

    //分页查询
    PageResult<Book> findPageByCondition(BookDto dto);

    //根据id删除
    Result delById(Integer id);

    //添加
    Result addBook(Book book);

    //修改
    Result upBook(Book book);

    Book findOne(Integer id);
}
