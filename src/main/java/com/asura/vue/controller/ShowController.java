package com.asura.vue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/7/007 21:36
 */
@Controller
@RequestMapping("/show")
public class ShowController {

    @RequestMapping("/book")
    public String book(){
        return "index";
    }

    @RequestMapping("/site")
    public String site(){
        return "site";
    }
}
