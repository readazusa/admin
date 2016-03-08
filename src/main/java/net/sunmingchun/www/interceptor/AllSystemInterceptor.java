package net.sunmingchun.www.interceptor;


import net.sunmingchun.www.admin.log.po.OperationLogPO;
import net.sunmingchun.www.admin.log.po.VisitLogPO;
import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.base.service.IBaseTheadService;
import net.sunmingchun.www.base.service.TheadService;
import net.sunmingchun.www.util.CodeConstantUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by smc on 2016/1/23.
 */
public class AllSystemInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private TheadService theadService;

    @Resource(name = "logService")
    private IBaseTheadService baseTheadService;

    private  static  final Logger log  = LoggerFactory.getLogger("AllSystemInterceptor");
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
//        Subject subject = SecurityUtils.getSubject();
//        UserPO userPO = (UserPO)subject.getPrincipal();
//        if(null != userPO){
//            subject.getSession().setAttribute(CodeConstantUtils.USER_INFO,userPO);
//            return true;
//        }else{
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String remoteAddr = null;
        if (request.getHeader("x-forwarded-for") == null) {
            remoteAddr =  request.getRemoteAddr();
        }else{
            remoteAddr =  request.getHeader("x-forwarded-for");
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        VisitLogPO visitLogPO = new VisitLogPO();
        visitLogPO.setAddress(request.getLocalAddr());
        visitLogPO.setMethod(handlerMethod.toString());
        visitLogPO.setUrl(request.getRequestURI());
        visitLogPO.setUserAgent(request.getHeader("user-agent"));
        visitLogPO.setUserIp(remoteAddr);
        visitLogPO.setUsername(request.getRemoteHost());
        theadService.execute(baseTheadService,visitLogPO);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
