package net.sunmingchun.www.shiro.filter;

import net.sunmingchun.www.shiro.token.MyUsernamePasswordToken;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

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
        String condition = this.getCondition((HttpServletRequest)request);
        String password = this.getPassword((HttpServletRequest)request);
        String isRemember = this.getIsRemember((HttpServletRequest) request);
        String reqId = this.getReqIp((HttpServletRequest)request);
        String verCode = this.getVerCode((HttpServletRequest)request);
        MyUsernamePasswordToken myUsernamePasswordToken = new MyUsernamePasswordToken(condition,password,verCode,reqId);
        if(IS_REMEMBER.equals(isRemember)){
            myUsernamePasswordToken.setRememberMe(true);
        }else{
            myUsernamePasswordToken.setRememberMe(false);
        }
        return myUsernamePasswordToken;
    }

    public String  getCondition(HttpServletRequest request){
        return request.getParameter("condition");
    }

    public String getIsRemember(HttpServletRequest request){
        return request.getParameter("isRemember");
    }

    public String  getPassword(HttpServletRequest request){
        return request.getParameter("password");
    }

    public String getReqIp(HttpServletRequest request){
        return request.getRemoteAddr();
    }

    public String getVerCode(HttpServletRequest request){
        return request.getParameter("verCode");
    }

}
