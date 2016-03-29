package net.sunmingchun.www.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * net.sunmingchun.www.interceptor
 * Created by smc
 * date on 2016/3/29.
 * Email:sunmch@163.com
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean validateToken = false;
        HttpSession session = request.getSession();
        String serverToken = (String) session.getAttribute("token");
        String clientToken = request.getParameter("token");
        if(StringUtils.isBlank(serverToken)){
            validateToken = true;
            session.setAttribute("token",clientToken);
        }else if(!serverToken.equals(clientToken)){
            validateToken = true;
            session.setAttribute("token",clientToken);
        }
        return validateToken;
    }

}
