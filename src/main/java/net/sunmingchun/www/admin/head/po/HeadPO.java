package net.sunmingchun.www.admin.head.po;

import net.sunmingchun.www.base.po.BasePO;

/**
 * Created by smc on 2016/1/22.
 */
public class HeadPO extends BasePO{

    public int type;   //头像类型 0:自定义  1:经典  2:动态

    public String contentType;  //头像图片类型

    private String suffix;  //后缀

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
