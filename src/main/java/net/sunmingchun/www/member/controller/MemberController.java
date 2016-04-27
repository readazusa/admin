package net.sunmingchun.www.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * net.sunmingchun.www.population.controller
 * Created by smc
 * date on 2016/3/30.
 * Email:sunmch@163.com
 */
@Controller
@RequestMapping("member")
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @RequestMapping("index")
    public String index(){
        return "member/index";
    }

    @RequestMapping("page")
    public String page(@RequestParam("page") int page){
        log.debug("刷新分页");
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        return "member/test";
    }

    @RequestMapping("vedio")
   public  String vedio(){
       return "member/vedio";
   }

}
