package net.sunmingchun.www.admin.log.po;

import net.sunmingchun.www.base.po.BasePO;

/**
 * Created by smc on 2016/1/23.
 * 所有的访问log实体类
 */
public class VisitLogPO  extends BasePO{

    private String userAgent;   //用的请求来源

    private  String userIp;   //用户的访问ip

    private  String address;   //访问的本地服务器IP

    private String url;  //访问的url

    private  String username;  //用户名

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
