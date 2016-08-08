package net.sunmingchun.www.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * net.sunmingchun.www.util
 * Created by smc
 * date on 2016/3/1.
 * Email:sunmch@163.com
 * ftp文件上传
 */
public final class FtpUtils {


    private String username="ftpadmin";

    private String password="ftpadmin";

    private int port=2221;

    private String ip="1551sp9557.imwork.net";

    private FTPClient ftpClient = null;


    private static FtpUtils ftpUtils = null;


    private final static Logger log = LoggerFactory.getLogger(FtpUtils.class);

    private  FtpUtils(){
         if(ftpClient == null){
             ftpClient = new FTPClient();
             try {
                 ftpClient.connect(ip,port);
                 Boolean login = ftpClient.login(username,password);
                 int replyCode = ftpClient.getReplyCode();
                 Boolean replayBool = FTPReply.isPositiveCompletion(replyCode);
                 if(!replayBool){
                     logout();
                 }
                 log.debug("登陆成功与否: {}",replayBool);
                 log.debug("是否成功登陆: {}",replyCode);
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

    public void logout(){
        try {
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     *
     * @param remote   远程ftp文件夹
     * @param inputStream   //需要上传的文件流
     * @return
     */
    public void sendFile(String dir,String remote, InputStream inputStream){
        if(!ftpClient.isConnected()){
            login();
        }
        try {
            if(ftpClient.listFiles(dir).length==0){
                ftpClient.makeDirectory(dir);
            }
            ftpClient.changeWorkingDirectory(dir);
            ftpClient.storeFile(remote,inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            logout();
        }
    }
    public void sendFile(String dir,String remote, File file){
        try {
            FileInputStream inputStream = new FileInputStream(file);
            this.sendFile(dir,remote,inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void login(){
        try {
            ftpClient.connect(ip,port);
            ftpClient.login(username,password);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
