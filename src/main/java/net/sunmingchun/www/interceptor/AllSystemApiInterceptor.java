package net.sunmingchun.www.interceptor;


import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.util.CodeConstantUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by smc on 2016/1/23.
 */
public class AllSystemApiInterceptor extends HandlerInterceptorAdapter {

    private  static  final Logger log  = LoggerFactory.getLogger(AllSystemApiInterceptor.class);
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }

    /**
     * @param request
     * @param response
     * @param handler  (org.springframework.web.method.HandlerMethod)
     * @return
     * request.getHeader("user-agent");  获得请求头的参数
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
