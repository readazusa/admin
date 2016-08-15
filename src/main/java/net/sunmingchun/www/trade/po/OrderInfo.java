package net.sunmingchun.www.trade.po;

import java.util.Date;

/**
 * club.lovety.user.entity
 * Created by smc
 * date on 2016/4/19.
 * Email:sunmch@163.com
 * 子订单信息实体类
 */
public class OrderInfo {

    private String uid;  //订单号

    private String itemId;

    private  String itemName;

    private String buyerNick;

    private String openId;

    private float  adjustFee;   //手动调整价格

    private float divideOrderFee;  //订单实付金额

    private float origFee;  //原价

    private float discountFee;  //优惠价格

    private Date createTime;

    private Date updateTime;

    private Date consignTime;  //发货时间

    private int count;  //数量


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public float getAdjustFee() {
        return adjustFee;
    }

    public void setAdjustFee(float adjustFee) {
        this.adjustFee = adjustFee;
    }

    public float getDivideOrderFee() {
        return divideOrderFee;
    }

    public void setDivideOrderFee(float divideOrderFee) {
        this.divideOrderFee = divideOrderFee;
    }

    public float getOrigFee() {
        return origFee;
    }

    public void setOrigFee(float origFee) {
        this.origFee = origFee;
    }

    public float getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(float discountFee) {
        this.discountFee = discountFee;
    }

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

    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
