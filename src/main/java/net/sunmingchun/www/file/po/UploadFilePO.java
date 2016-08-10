package net.sunmingchun.www.file.po;

import net.sunmingchun.www.base.po.BasePO;

/**
 * Created by 念梓  on 2016/8/9.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
public class UploadFilePO extends BasePO{


    private String name;

    private String contentType;

    private long size;

    private String url;

    private String subffix;

    private String origName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubffix() {
        return subffix;
    }

    public void setSubffix(String subffix) {
        this.subffix = subffix;
    }

    public String getOrigName() {
        return origName;
    }

    public void setOrigName(String origName) {
        this.origName = origName;
    }
}
