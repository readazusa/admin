package net.sunmingchun.www.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * net.sunmingchun.www.shiro.token
 * Created by smc
 * date on 2016/2/25.
 * Email:sunmch@163.com
 */
public class MyUsernamePasswordToken extends UsernamePasswordToken {

    private String  verCode;  //验证码

    private  String  reqIp;   //请求的ip

    private String condition;   //第一个查询条件 用户名  手机号 邮箱

    private String psd;

    public MyUsernamePasswordToken(){

    }

    public MyUsernamePasswordToken(String condition,String password){
        this.condition = condition;
        this.psd = password;
    }

    public  MyUsernamePasswordToken(String condition,String password,String verCode){
        this(condition,password);
        this.verCode = verCode;
    }

    public  MyUsernamePasswordToken(String condition,String password,String verCode,String reqIp){
        this(condition,password,verCode);
        this.reqIp = reqIp;
    }

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getReqIp() {
        return reqIp;
    }

    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }
}
