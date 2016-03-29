package net.sunmingchun.www.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * net.sunmingchun.www.shiro.token
 * Created by smc
 * date on 2016/2/25.
 * Email:sunmch@163.com
 */
public class MyUsernamePasswordToken extends UsernamePasswordToken {

    private String validatecode;

    public String getValidatecode() {
        return validatecode;
    }

    public void setValidatecode(String validatecode) {
        this.validatecode = validatecode;
    }
}
