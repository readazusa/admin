package net.sunmingchun.www.util;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * net.sunmingchun.www.util
 * Created by smc
 * date on 2016/3/1.
 * Email:sunmch@163.com
 * ftp文件上传
 */
public final class FtpUtils {

    private String username;

    private String password;

    private int port;

    private String ip;

    private FTPClient ftpClient = null;


    private static FtpUtils ftpUtils = null;

    private  FtpUtils(){
         if(ftpClient == null){
             ftpClient = new FTPClient();
             try {
                 ftpClient.connect(ip);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
        if(!ftpClient.isConnected()){
            try {
                ftpClient.login(username,password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public  static FtpUtils getInstance(){
        if(ftpUtils == null){
            ftpUtils = new FtpUtils();
        }
        return ftpUtils;
    }

    /**
     *
     * @param remote   远程ftp文件夹
     * @param inputStream   //需要上传的文件流
     * @return
     */
    public String sendFile(String remote, InputStream inputStream){
        return null;
    }




    
}
