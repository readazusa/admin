package net.sunmingchun.www.item.service.impl;

import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.item.dao.IItemDao;
import net.sunmingchun.www.item.po.ItemInfo;
import net.sunmingchun.www.item.po.ItemVsFilePO;
import net.sunmingchun.www.item.service.IItemService;
import net.sunmingchun.www.util.UuidUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * net.sunmingchun.www.item.service.impl
 * Created by smc
 * date on 2016/4/27.
 * Email:sunmch@163.com
 */
@Service
public class ItemServiceImpl implements IItemService {

    @Resource
    private IItemDao itemDao;

    @Override
    public ItemInfo queryObjectById(String id) {
        return itemDao.queryObjectById(id);
    }

    @Override
    public ItemInfo queryObjectById(int id) {
        return null;
    }

    @Override
    public List<ItemInfo> queryList() {
        return null;
    }

    @Override
    @Transactional
    public void save(ItemInfo obj) {
        obj.setUpdateTime(new Date());
        obj.setCreateTime(new Date());
        obj.setUid(UuidUtils.getUpperUuid());
        itemDao.save(obj);
        String fileIds = obj.getFileIds();
        if(StringUtils.isNoneBlank(fileIds)){
            Arrays.asList(fileIds.split("&&")).forEach(e->{
                ItemVsFilePO itemVsFilePO = new ItemVsFilePO();
                itemVsFilePO.setFileId(e);
                itemVsFilePO.setItemId(obj.getUid());
                itemVsFilePO.setId(UuidUtils.getUpperUuid());

            });
        }

        itemDao.save(obj);
    }

    @Override
    public void deleteById(String uid) {

    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(ItemInfo itemInfo) {

    }

    @Override
    public int getTotalCount(ItemInfo itemInfo) {
        return itemDao.queryTotalCount(itemInfo);
    }

    @Override
    public BasePagePO<ItemInfo> getBasePagePO(int pageIndex, int pageSize, ItemInfo itemInfo) {
        return null;
    }

    @Override
    public List<ItemInfo> queryListPO(int pageIndex, int pageSize, ItemInfo itemInfo) {
        return null;
    }

    @Override
    public BasePagePO<ItemInfo> getBasePagePO(int pageIndex, int pageSize, UserPO userPO, int draw) {
        return null;
    }

    @Override
    public BasePagePO<ItemInfo> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.setSearch(searchValue);
        BaseSearchPO<ItemInfo> baseSearchPO = new BaseSearchPO<>();
        baseSearchPO.setObj(itemInfo);
        baseSearchPO.setPageSize(pageSize);
        baseSearchPO.setPageIndex(pageIndex);
        baseSearchPO.setOrderName(orderColumn);
        baseSearchPO.setOrderValue(orderValue);
        /*
         *上面是构造查询条件
         *
         * 下面是返回查询结构
         */
        List<ItemInfo> itemInfos = itemDao.queryPage(baseSearchPO);
        int totalCount = this.getTotalCount(itemInfo);
        BasePagePO<ItemInfo> basePagePO = new BasePagePO<>();
        basePagePO.setData(itemInfos);
        basePagePO.setDraw(draw);
        basePagePO.setRecordsTotal(totalCount);
        basePagePO.setRecordsFiltered(totalCount);
        return basePagePO;
    }


}
