package net.sunmingchun.www.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * net.sunmingchun.www.util
 * Created by smc
 * date on 2016/3/9.
 * Email:sunmch@163.com
 * md5 或者har加密
 */
public class SecUtils {


    public  static String  getMD5(String source){
//        DigestUtils.
        return DigestUtils.md5Hex(source);

    }


    public static void main(String[] args) {
        System.out.println(getMD5("123"));
    }

}
