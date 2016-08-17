package net.sunmingchun.www.index.po;

import net.sunmingchun.www.base.po.BasePO;

/**
 * Created by 念梓  on 2016/8/17.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
public class IndexPageInfo  extends BasePO{

    private String type;   //显示的类型标记 0:首页的头部滚动  ,1:中部广告 ,2:中部大图片

    private String picUrl;

    private String contentUrl;

    private String isShow;   //是否需要显示  0:显示 , 1:不显示

    private String title;

    private int sort;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
