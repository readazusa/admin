package net.sunmingchun.www.item.po;

import net.sunmingchun.www.base.po.BasePO;

/**
 * Created by 念梓  on 2016/8/9.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:商品 文件关联表
 */
public class ItemVsFilePO extends BasePO{

    private String itemId;

    private String fileId;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
