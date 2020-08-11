package com.asura.vue.domain;

import lombok.Data;

import java.util.List;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/7/007 21:53
 */
@Data
public class PageResult<T> {
    private Long total;
    private Long totalPageNum;
    private List<T> list;

    public PageResult(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public PageResult() {
    }

    public PageResult(Long total, Long totalPageNum, List<T> list) {
        this.total = total;
        this.totalPageNum = totalPageNum;
        this.list = list;
    }
}
