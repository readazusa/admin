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


    private String username = "ftpadmin";

    private String password = "ftpadmin";

    private int port = 2221;

    private String ip = "1551sp9557.imwork.net";

    private FTPClient ftpClient = null;


    private static FtpUtils ftpUtils = null;


    private final static Logger log = LoggerFactory.getLogger(FtpUtils.class);

    private FtpUtils() {
        if (ftpClient == null) {
            ftpClient = new FTPClient();
            try {
                ftpClient.connect(ip, port);
                Boolean login = ftpClient.login(username, password);
                int replyCode = ftpClient.getReplyCode();
                Boolean replayBool = FTPReply.isPositiveCompletion(replyCode);
                if (!replayBool) {
                    logout();
                }
                log.debug("登陆成功与否: {}", replayBool);
                log.debug("是否成功登陆: {}", replyCode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static FtpUtils getInstance() {
        if (ftpUtils == null) {
            ftpUtils = new FtpUtils();
        }
        return ftpUtils;
    }

    public void logout() {
        try {
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param remote      远程ftp文件夹
     * @param inputStream //需要上传的文件流
     * @return
     */
    public boolean sendFile(String dir, String remote, InputStream inputStream) {
        Boolean isUploadFtp = true;
        if (!ftpClient.isConnected()) {
            login();
        }
        try {
            ftpClient.changeToParentDirectory();
            if (ftpClient.listFiles(dir).length == 0) {
                ftpClient.makeDirectory(dir);
            }
            ftpClient.changeWorkingDirectory(dir);
            /**
             * 调用FTPClient.enterLocalPassiveMode();这个方法的意思就是每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据。
             * 为什么要这样做呢，因为ftp server可能每次开启不同的端口来传输数据，但是在linux上，由于安全限制，可能某些端口没有开启，所以就出现阻塞。
             */
            ftpClient.enterLocalPassiveMode();//
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("UTF-8");
            //二进制
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            Boolean uploadFtpBool = ftpClient.storeFile(remote, inputStream);
            log.info("==========上传ftp返回结果:{}============", uploadFtpBool);
        } catch (IOException e) {
            log.error("上传ftp失败: ", e);
            isUploadFtp = false;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            logout();
        }
        return isUploadFtp;
    }

    public boolean sendFile(String dir, String remote, File file) {
        boolean bool = false;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            bool =  this.sendFile(dir, remote, inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    public void login() {
        try {
            ftpClient.connect(ip, port);
            ftpClient.login(username, password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream(new File("G:" + File.separator + "PortalController.java"));
            FtpUtils.getInstance().sendFile("1111111", "test.txt", inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
