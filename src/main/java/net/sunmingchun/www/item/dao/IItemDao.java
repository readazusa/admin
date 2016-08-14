package net.sunmingchun.www.item.dao;

import net.sunmingchun.www.base.dao.IDao;
import net.sunmingchun.www.file.po.UploadFilePO;
import net.sunmingchun.www.item.po.ItemInfo;
import net.sunmingchun.www.item.po.ItemVsFilePO;

import java.util.List;

/**
 * net.sunmingchun.www.item.dao
 * Created by smc
 * date on 2016/4/27.
 * Email:sunmch@163.com
 */
public interface IItemDao extends IDao<ItemInfo>{

    public int saveItemVsFile(ItemVsFilePO itemVsFilePO);

    public List<UploadFilePO> getUploadFileListByItemId(String uid);

    public int deleteItemVsFileByItemId(String itemId);
}
