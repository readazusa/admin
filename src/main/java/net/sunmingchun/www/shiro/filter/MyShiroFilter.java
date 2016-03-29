package net.sunmingchun.www.shiro.filter;

import net.sunmingchun.www.shiro.token.MyUsernamePasswordToken;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * net.sunmingchun.www.shiro.filter
 * Created by smc
 * date on 2016/2/25.
 * Email:sunmch@163.com
 */
public class MyShiroFilter extends FormAuthenticationFilter {

    private static final String IS_REMEMBER="true";

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
//        String condition = this.getCondition(request);
//        String password = this.getPassword(request);
//        String isRemember = this.getIsRemember( request);
//        String reqId = this.getReqIp(request);
//        String verCode = this.getVerCode(request);
////        MyUsernamePasswordToken myUsernamePasswordToken = new MyUsernamePasswordToken(condition,password,verCode,reqId);
//        if(IS_REMEMBER.equals(isRemember)){
//            myUsernamePasswordToken.setRememberMe(true);
//        }else{
//            myUsernamePasswordToken.setRememberMe(false);
//        }
//        return myUsernamePasswordToken;
        return null;
    }

    public String  getCondition(ServletRequest request){
        return request.getParameter("condition");
    }

    public String getIsRemember(ServletRequest request){
        return request.getParameter("isRemember");
    }

    public String  getPassword(ServletRequest request){
        return request.getParameter("password");
    }

    public String getReqIp(ServletRequest request){
        return request.getRemoteAddr();
    }

    public String getVerCode(ServletRequest request){
        return request.getParameter("verCode");
    }

}
