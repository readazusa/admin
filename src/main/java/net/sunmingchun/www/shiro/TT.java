package net.sunmingchun.www.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;


/**
 * net.sunmingchun.www.shiro
 * Created by smc
 * date on 2016/2/25.
 * Email:sunmch@163.com
 */
public class TT {
    public static void main(String[] args) {
//        org.apache.shiro.mgt.SecurityManager
        Subject subject =  SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();

    }
}
