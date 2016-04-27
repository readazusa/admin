package net.sunmingchun.www.item.po;

import java.util.Date;

/**
 * club.lovety.portal.entity
 * Created by smc
 * date on 2016/4/20.
 * Email:sunmch@163.com
 * 购物车实体类
 */
public class ShopCart {

    private String uid;

    private String openId;

    private String itemId;

    private int count;

    private  String phonePicUrl;

    private String pcPicUrl;

    private String title;

    private Date createTime;

    private Date updateTime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPhonePicUrl() {
        return phonePicUrl;
    }

    public void setPhonePicUrl(String phonePicUrl) {
        this.phonePicUrl = phonePicUrl;
    }

    public String getPcPicUrl() {
        return pcPicUrl;
    }

    public void setPcPicUrl(String pcPicUrl) {
        this.pcPicUrl = pcPicUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
