package net.sunmingchun.www.item.po;

import java.util.Date;

/**
 * club.lovety.portal.entity
 * Created by smc
 * date on 2016/4/21.
 * Email:sunmch@163.com
 *评论实体类
 */
public class CommentInfo {


    private  String uid;

    private String itemId;

    private String openId;

    private String result;  //评价结果 good bad middle

    private String content;

    private Date createTime;

    private String parentId;

    private String type;   //0 主评价  1：追评

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
