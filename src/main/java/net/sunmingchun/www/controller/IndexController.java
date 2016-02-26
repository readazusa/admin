package net.sunmingchun.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by smc on 2015/11/19.
 */

@Controller
public class IndexController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public  String login(){
        return  "login";
    }

    @RequestMapping("auth")
    public String auth(){
        return null;
    }
}
