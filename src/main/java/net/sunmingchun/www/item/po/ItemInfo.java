package net.sunmingchun.www.item.po;

import net.sunmingchun.www.base.po.BasePO;

import java.util.Date;

/**
 * club.lovety.portal.entity
 * Created by smc
 * date on 2016/4/19.
 * Email:sunmch@163.com
 * 商品信息实体类
 *
 */
public class ItemInfo extends BasePO{

    private  String uid;

    private String title;

    private float price;

    private String pcPicUrl;  //pc端的图片url

    private String phonePicUrl;  //手机端图片url

    private  String descr;

    private Date listTime;//上架时间

    private Date delistTime;//下架时间

    private int stock;  //库存

    private float discountPrice;  //打折后的价格

    private String orgin;  // 产地

    private int postage;  //邮费

    private String status;  // 0:上架  1:下架

    private String search;
    /**
     * 交易商品对应的类目ID
     */
    private String cid;

    private String conpany;  //单位  斤  瓶


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPcPicUrl() {
        return pcPicUrl;
    }

    public void setPcPicUrl(String pcPicUrl) {
        this.pcPicUrl = pcPicUrl;
    }

    public String getPhonePicUrl() {
        return phonePicUrl;
    }

    public void setPhonePicUrl(String phonePicUrl) {
        this.phonePicUrl = phonePicUrl;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getListTime() {
        return listTime;
    }

    public void setListTime(Date listTime) {
        this.listTime = listTime;
    }

    public Date getDelistTime() {
        return delistTime;
    }

    public void setDelistTime(Date delistTime) {
        this.delistTime = delistTime;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getOrgin() {
        return orgin;
    }

    public void setOrgin(String orgin) {
        this.orgin = orgin;
    }

    public int getPostage() {
        return postage;
    }

    public void setPostage(int postage) {
        this.postage = postage;
    }

    public String getConpany() {
        return conpany;
    }

    public void setConpany(String conpany) {
        this.conpany = conpany;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
