package net.sunmingchun.www.controller;

import net.sunmingchun.www.util.CodeConstantUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if(null != session.getAttribute(CodeConstantUtils.USER_INFO)){
            return  "index";
        }
        return  "login";
    }

    @RequestMapping("auth")
    public String auth(){
        return "index";
    }
}
