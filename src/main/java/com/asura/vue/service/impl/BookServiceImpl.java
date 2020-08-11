package com.asura.vue.service.impl;

import com.asura.vue.domain.Book;
import com.asura.vue.domain.PageResult;
import com.asura.vue.domain.Result;
import com.asura.vue.dtos.BookDto;
import com.asura.vue.mapper.BookMapper;
import com.asura.vue.service.BookService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/7/007 21:35
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public PageResult<Book> findPageByCondition(BookDto dto) {
        QueryWrapper<Book> qw = new QueryWrapper<>();

        if(!StringUtils.isEmpty(dto.getAuthor())){
            qw.lambda().like(Book::getAuthor,dto.getAuthor());
        }
        if(!StringUtils.isEmpty(dto.getBookName()))
            qw.lambda().like(Book::getBookName,dto.getBookName());
        if(!StringUtils.isEmpty(dto.getStartTime()))
            qw.lambda().ge(Book::getPressTime,dto.getStartTime());
        if(!StringUtils.isEmpty(dto.getEndTime()))
            qw.lambda().le(Book::getPressTime,dto.getEndTime());
        Page<Book> page = bookMapper.selectPage(new Page<>(dto.getPageNum(), dto.getPageSize()), qw);

        return new PageResult<Book>(page.getTotal(),page.getRecords());
    }

    @Override
    public Result delById(Integer id) {
        int i = bookMapper.deleteById(id);
        if(i>0){
            return new Result(true,"删除成功");
        }else{
            return new Result(false,"删除失败");
        }
    }

    @Override
    public Result addBook(Book book) {
        int i = bookMapper.insert(book);
        if(i>0){
            return new Result(true,"添加成功");
        }else{
            return new Result(false,"添加失败");
        }
    }

    @Override
    public Result upBook(Book book) {
        int i = bookMapper.updateById(book);
        if(i>0){
            return new Result(true,"修改成功");
        }else{
            return new Result(false,"修改失败");
        }
    }

    @Override
    public Book findOne(Integer id) {
        return bookMapper.selectById(id);
    }
}
