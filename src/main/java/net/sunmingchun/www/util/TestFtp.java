
package net.sunmingchun.www.util;

        import org.apache.commons.net.ftp.FTP;
        import org.apache.commons.net.ftp.FTPClient;
        import org.apache.commons.net.ftp.FTPFile;
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
public final class TestFtp {


    private String username="ftpadmin";

    private String password="ftpadmin";

    private int port=2221;

    private String ip="1551sp9557.imwork.net";

    private FTPClient ftpClient = null;


    private static TestFtp ftpUtils = null;


    private final static Logger log = LoggerFactory.getLogger(FtpUtils.class);

    private  TestFtp(){
        if(ftpClient == null){
            ftpClient = new FTPClient();
            try {
                ftpClient.connect(ip,port);
                Boolean login = ftpClient.login(username,password);
                int replyCode = ftpClient.getReplyCode();
                Boolean replayBool = FTPReply.isPositiveCompletion(replyCode);
                log.debug("登陆成功与否: {}",replayBool);
                log.debug("是否成功登陆: {}",replyCode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Boolean content = ftpClient.isConnected();
            log.debug("2323");
//             if(!ftpClient.isConnected()){
//             }
        }
//        if(ftpClient.isConnected()){
//            try {
//                Boolean login = ftpClient.login(username,password);
//                log.debug("连接ftp地址:{},端口:{},登录返回结果:{}",ftpClient.getRemoteAddress(),ftpClient.getRemotePort(),login);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public  static TestFtp getInstance(){
        if(ftpUtils == null){
            ftpUtils = new TestFtp();
        }
        return ftpUtils;
    }

    public void logout(){
        try {
            Boolean bool =  ftpClient.logout();
            log.debug("退出结果: {}",bool);
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
    public String sendFile(String remote, InputStream inputStream){

        try {
            Boolean parent = ftpClient.changeToParentDirectory();
            log.debug("返回父目录：{} ",parent);
            Boolean createDir = ftpClient.makeDirectory("12355");
            Boolean b = ftpClient.changeWorkingDirectory("12355");
//            FTPFile[] ftpFile = ftpClient.mlistDir("123");
//            int a = ftpClient.list("123");
//            Boolean createDir = ftpClient.makeDirectory("123");

            log.debug("创建文件夹: {}",createDir);
//            log.debug("设置远程目录:  {}",b);
//            ftpClient.
            ftpClient.enterLocalPassiveMode();
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            Boolean bool = ftpClient.storeFile(remote,inputStream);
//            inputStream.close();
            log.debug("上传ftp返回的编码: {}",bool);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void loadFile(String path){
        try {
            FTPFile[] ftpFiles = ftpClient.listFiles(path);
            log.debug("f: ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void login(){
        Boolean content = ftpClient.isConnected();
        log.debug("2323");
    }
    public static void main(String[] args) {
        TestFtp testFtp = TestFtp.getInstance();
//        log.debug("ftputiles:hashcode: {}",testFtp.getClass().hashCode());
//        FtpUtils ftpUtils2 = FtpUtils.getInstance();
//
//        log.debug("ftputiles2:hashcode: {}",ftpUtils2.getClass().hashCode());
//        ftpUtils2.login();
//        ftpUtils.loadFile("123");
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("G:"+ File.separator+"PortalController.java"));
            testFtp.sendFile("ty.java",fileInputStream);

            testFtp.sendFile("ty22.java",fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}
