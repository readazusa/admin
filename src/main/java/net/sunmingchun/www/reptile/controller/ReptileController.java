package net.sunmingchun.www.reptile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by smc on 2015/12/25.
 */
@RequestMapping("reptile")
@Controller
public class ReptileController {

    @RequestMapping("index")
    public String index(){
        return "reptile/index";
    }
}
