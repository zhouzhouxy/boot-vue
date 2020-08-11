package com.asura.vue.service.impl;

import com.asura.vue.domain.Result;
import com.asura.vue.domain.Site;
import com.asura.vue.mapper.SiteMapper;
import com.asura.vue.service.SiteService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/8/008 10:53
 */
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteMapper siteMapper;


    @Override
    public List<Site> findAll() {
        return siteMapper.selectList(null);
    }

    @Override
    public Site findByName(String name) {
        QueryWrapper<Site> qw = new QueryWrapper<>();
        qw.lambda().eq(Site::getPersonName,name);

        Site site = siteMapper.selectOne(qw);
        return site;
    }

    @Override
    public int insert(Site site) {
        return siteMapper.insert(site);
    }

    @Override
    public Site findByNumber(String number) {
        QueryWrapper<Site> qw = new QueryWrapper<>();
        qw.lambda().eq(Site::getSortSite,number);
        return    siteMapper.selectOne(qw);
    }

    @Override
    public void deleteAll() {
        siteMapper.delete(null);
    }

    @Override
    public Result changeSite(String startNum, String changeNum) {
        //先查询
        Site site1 = findByNumber(startNum);
        Site site2 = findByNumber(changeNum);
        if(site1==null&&site2==null){
            //如果两个位置都没有人的话返回
            return new Result(false,"两个位置都没有人啊");
        }else{
            if(site1==null){
                //证明这个位置没有人
                site2.setSortSite(startNum);
                siteMapper.updateById(site2);
            }
            if(site2==null){
                site1.setSortSite(changeNum);
                siteMapper.updateById(site1);
            }
            if(site1!=null&&site2!=null){
                site1.setSortSite(changeNum);
                site2.setSortSite(startNum);
                siteMapper.updateById(site1);
                siteMapper.updateById(site2);
            }
            //修改
            return new Result(true,"变更成功");
        }
    }

    @Override
    public void update(Site number) {
        //根据id修改
        siteMapper.updateById(number);
    }
}
