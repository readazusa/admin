package net.sunmingchun.www.util;

/**
 * net.sunmingchun.www.util
 * Created by smc
 * date on 2016/3/1.
 * Email:sunmch@163.com
 * http调用实体类
 * wepapi的接口调用
 */
public final class HttpUtils {

    public static HttpUtils httpUtils =null;

    private HttpUtils(){

    }

    public static  HttpUtils getInstance(){
        if(httpUtils == null){
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

}
