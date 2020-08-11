package com.asura.vue.service;

import com.asura.vue.domain.Result;
import com.asura.vue.domain.Site;

import java.util.List;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/8/008 10:52
 */
public interface SiteService {
    //查询所有
    List<Site> findAll();

    //根据name查询
    Site findByName(String name);

    //插入
    int insert(Site site);

    //判断位置是否已经存在
    Site findByNumber(String number);

    void deleteAll();

    Result changeSite(String startNum, String changeNum);

    void update(Site number);
}
