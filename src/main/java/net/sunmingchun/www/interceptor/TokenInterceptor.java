package net.sunmingchun.www.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * net.sunmingchun.www.interceptor
 * Created by smc
 * date on 2016/3/29.
 * Email:sunmch@163.com
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Method method = handlerMethod.getMethod();
////            Token annotation = method.getAnnotation(Token.class);
////            if (annotation != null) {
////                boolean needSaveSession = annotation.save();
////                if (needSaveSession) {
////                    request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
////                }
////                boolean needRemoveSession = annotation.remove();
////                if (needRemoveSession) {
////                    if (isRepeatSubmit(request)) {
////                        return false;
////                    }
////                    request.getSession(false).removeAttribute("token");
////                }
//            }
//            return true;
//        } else {
////            return super.preHandle(request, response, handler);
//        }
         return true;
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
//        String serverToken = (String) request.getSession(false).getAttribute("token");
//        if (serverToken == null) {
//            return true;
//        }
//        String clinetToken = request.getParameter("token");
//        if (clinetToken == null) {
//            return true;
//        }
//        if (!serverToken.equals(clinetToken)) {
//            return true;
//        }
        return false;
    }
}
