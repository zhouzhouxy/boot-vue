package com.asura.vue.controller;

import com.asura.vue.domain.Result;
import com.asura.vue.domain.Site;
import com.asura.vue.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static javax.swing.UIManager.getString;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/8/008 10:02
 */
@RequestMapping("/site")
@RestController
public class SiteController {

    @Autowired
    private SiteService siteService;

    /**
     * 这个方法包括下面两个 makesite，getString方法应该是放在service层实现的，
     * 当时写的时候没有注意，后面可以自己更改，提高代码的可读性
     * @param site
     * @return
     */
    @RequestMapping("/make_site")
    public ResponseEntity<List<Site>> makeSite(@RequestBody Site site){

        List<Site> list = siteService.findAll();
        if(site.getPersonName().trim().length()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //判断是否已经存在
        Site personSite
                = siteService.findByName(site.getPersonName());
        if(personSite!=null){
            //表示这个人已经有了位置
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       /* String aa = getString(site.getAhead());
        site.setSortSite(aa);
        //插入数据库中
        siteService.insert(site);*/
        //插入到数据库中
        makeSite1(site);
        //再次查询并返回
        return ResponseEntity.ok(siteService.findAll());
    }
    private Lock lock =new ReentrantLock();
    public  void makeSite1(Site site){

            lock.lock();
            try {
                String str= getString(site.getAhead());
                Site byNumber = siteService.findByNumber(str);
                if(site.getPersonName().equals("周粤湘")){
                    //先查询"4,1"这个位置有没有人有则修改他的位置
                    Site number = siteService.findByNumber("3,1");
                    if(number==null){
                        //如果这个位置没有就直接插入
                        site.setSortSite("3,1");
                        siteService.insert(site);
                        return;
                    }else{
                        //如果这个位置有了就重新给他生成一个位置
                        if(byNumber!=null){
                            //如果不等于null表示这个位置已经存在需要重新生成
                            str=null;
                            makeSite1(site);
                        }else{
                            //修改这个number位置
                            number.setSortSite(str);
                            //修改
                            siteService.update(number);

                            site.setSortSite("3,1");
                            siteService.insert(site);
                        }
                    }
                }else {
                    if (byNumber != null) {
                        //如果不等于null表示已经存在需要重新生成
                        str = null;
                        makeSite1(site);
                        //为什么用递归，因为越到后面重复的几率越高，如果只做if判断的话调用生成方法的话，后面的必定会重复的
                    } else {
                        //插入数据
                        site.setSortSite(str);
                        siteService.insert(site);
                    }
                }
            }finally {
                lock.unlock();
            }

     }

    private String getString(int ahead) {
        int i=0;
        int j=0;
        Random random = new Random();
        //判断是否要坐前四
        if(ahead==1){
            //前四
            i = random.nextInt(4)+1;
            j = random.nextInt(4)+1;

        }else{
            i = random.nextInt(8)+1;
            j = random.nextInt(4)+1;
        }
        return i + "," + j;
    }

    //页面加载时加载
    @GetMapping("/load_site")
    public ResponseEntity<List<Site>> loadSite(){
        return ResponseEntity.ok(siteService.findAll());
    }

    //重新随机生成
    @PostMapping("/random_site")
    public ResponseEntity<List<Site>> randomSite(@RequestBody Site site){
        //先将表全部删除
        siteService.deleteAll();
        //重新生成
        return makeSite(site);
    }

    @GetMapping("/delete_all")
    public ResponseEntity<Result> deleteAll(){
        try {
            siteService.deleteAll();
            return ResponseEntity.ok(new Result(true,"删除成功"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new Result(false,"删除失败"));
        }
    }


    //变更位置
    @PostMapping("/change_site")
    public ResponseEntity<Result> changeSite(@RequestBody Map<String,String>map){
        System.out.println(map.get("startNum")+"--->"+map.get("changeNum"));

        return ResponseEntity.ok(siteService.changeSite(map.get("startNum"),map.get("changeNum")));
    }
}
