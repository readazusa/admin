package net.sunmingchun.www.base.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.sunmingchun.www.util.BaseDateSerializer;

import java.util.Date;

/**
 * Created by smc on 2015/11/19
 *
 */
public class BasePO {
    private String id;
    private Date createTime;
    private Date updateTime;

    private String search; //模糊查询条件


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
