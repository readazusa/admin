package net.sunmingchun.www.admin.user.po;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.sunmingchun.base.po.BasePO;
import net.sunmingchun.util.BaseDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

/**
 * Created by smc on 2015/11/19.
 * 实体类
 */
public class UserPO extends BasePO{

    private String userCode;  //人员编号
    private String username;  //登陆名称
    private String name;
    private String sex;
    private Date birthday;
    private String province;
    private String city;
    private String address;
    private String idCard;   //身份证
    private String mobile;
    private String email;
    private  String  area;


    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @JsonSerialize(using = BaseDateSerializer.class)
    public Date getBirthday() {
        return birthday;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
