package net.sunmingchun.www.util;

/**
 * net.sunmingchun.www.util
 * Created by smc
 * date on 2016/3/1.
 * Email:sunmch@163.com
 */
public final class FtpUtils {

    private static FtpUtils ftpUtils = null;

    private  FtpUtils(){

    }

    public  static FtpUtils getInstance(){
        if(ftpUtils == null){
            ftpUtils = new FtpUtils();
        }
        return ftpUtils;
    }


    
}
