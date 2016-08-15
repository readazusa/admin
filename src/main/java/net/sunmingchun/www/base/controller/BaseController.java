package net.sunmingchun.www.base.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.Date;

/**
 * Created by smc on 2015/11/25.
 */
public abstract  class BaseController {

    public void saveSession(HttpSession session,String key,Object obj){
        session.setAttribute(key,obj);
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {

    }

    /**
     *
     * @param response
     * @param key
     * @param value
     * @param age 默认为0
     */
    public void saveCookie(HttpServletResponse response,String key,String value,long age){

    }

    public void saveCookie(HttpServletResponse response,String key,String value){

    }

    public String getOrderName(HttpServletRequest request,String orderColumnsStr){
        String orderParam = "";
        if(StringUtils.isNotBlank(orderColumnsStr)){
            orderParam="columns["+Integer.parseInt(orderColumnsStr)+"][data]";
        }
        return request.getParameter(orderParam);
    }




}
