package net.sunmingchun.www.trade.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.sunmingchun.www.util.BaseDateSerializer;

import java.util.Date;
import java.util.List;

/**
 * club.lovety.portal.entity
 * Created by smc
 * date on 2016/4/20.
 * Email:sunmch@163.com
 */
public class TradeInfo {

    private String uid;

    private float payment; //实付金额

    private float postFee;   //邮费

    private String receiveName;

    private String receiveProvince;

    private String receiveCity;

    private String receiveArea;

    private String receiveAddress;

    private String receiveZip;  //邮编

    private String receiveMobile;

    private String receivePhone;

    private String receiveTown; //收货人街道

    private String status; //订单状态  0:待付款  1：已付款， 2：待发货 ， 3：已收货 ，4：待评价 ,5:已完成

    private Date createTime;

    private Date updateTime;

    private float totalFee;   //总共金额

    private String buyerNick;

    private String openid;

    private Date consignTime;  //发货时间

    private List<OrderInfo> orderInfoList;

    private String search;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public float getPostFee() {
        return postFee;
    }

    public void setPostFee(float postFee) {
        this.postFee = postFee;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveProvince() {
        return receiveProvince;
    }

    public void setReceiveProvince(String receiveProvince) {
        this.receiveProvince = receiveProvince;
    }

    public String getReceiveCity() {
        return receiveCity;
    }

    public void setReceiveCity(String receiveCity) {
        this.receiveCity = receiveCity;
    }

    public String getReceiveArea() {
        return receiveArea;
    }

    public void setReceiveArea(String receiveArea) {
        this.receiveArea = receiveArea;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getReceiveZip() {
        return receiveZip;
    }

    public void setReceiveZip(String receiveZip) {
        this.receiveZip = receiveZip;
    }

    public String getReceiveMobile() {
        return receiveMobile;
    }

    public void setReceiveMobile(String receiveMobile) {
        this.receiveMobile = receiveMobile;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveTown() {
        return receiveTown;
    }

    public void setReceiveTown(String receiveTown) {
        this.receiveTown = receiveTown;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonSerialize(using = BaseDateSerializer.class)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(float totalFee) {
        this.totalFee = totalFee;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    public List<OrderInfo> getOrderInfoList() {
        return orderInfoList;
    }

    public void setOrderInfoList(List<OrderInfo> orderInfoList) {
        this.orderInfoList = orderInfoList;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
