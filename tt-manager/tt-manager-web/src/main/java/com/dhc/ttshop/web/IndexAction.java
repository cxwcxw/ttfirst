package com.dhc.ttshop.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: DHC
 * Date: 2017/9/1
 * Time: 9:24
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class IndexAction {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

}
