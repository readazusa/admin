package net.sunmingchun.www.item.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.sunmingchun.www.base.po.BasePO;
import net.sunmingchun.www.util.BaseDateSerializer;

import java.util.Date;

/**
 * club.lovety.portal.entity
 * Created by smc
 * date on 2016/4/26.
 * Email:sunmch@163.com
 */
public class ItemTypeInfo extends BasePO{

    private String uid;

    private String name;

    private int deep;

    private String sort;  //排序

    private Date createTime;

    private Date updateTime;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSerialize(using = BaseDateSerializer.class)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }


    @JsonSerialize(using = BaseDateSerializer.class)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
