package net.sunmingchun.www.controller;

import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.util.CodeConstantUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by smc on 2015/11/19.
 */

@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        log.info("logback测试输入文件");

        Cookie[] cookie = request.getCookies();
        Subject subject = SecurityUtils.getSubject();
        UserPO userPO = (UserPO)subject.getPrincipal();
        HttpSession session = request.getSession();
        Object obj = session.getAttribute(CodeConstantUtils.USER_INFO);
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

    @RequestMapping("logout")
    public String  logout(){
        return "login";
    }

    @RequestMapping("auth")
    public String auth(){
        return "index";
    }
}
