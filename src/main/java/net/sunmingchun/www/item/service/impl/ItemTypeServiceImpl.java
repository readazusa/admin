package net.sunmingchun.www.item.service.impl;

import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.item.dao.IItemTypeDao;
import net.sunmingchun.www.item.po.ItemTypeInfo;
import net.sunmingchun.www.item.service.IItemTypeService;
import net.sunmingchun.www.util.UuidUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 念梓  on 2016/8/15.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Service
public class ItemTypeServiceImpl implements IItemTypeService {

    @Resource
    private IItemTypeDao itemTypeDao;

    @Override
    public ItemTypeInfo queryObjectById(String id) {
        return itemTypeDao.queryObjectById(id);
    }

    @Override
    public ItemTypeInfo queryObjectById(int id) {
        return null;
    }

    @Override
    public List<ItemTypeInfo> queryList() {
        return itemTypeDao.queryList();
    }

    @Override
    public void save(ItemTypeInfo obj) {
        obj.setUid(UuidUtils.getUpperUuid());
        Date nowDate = new Date();
        obj.setCreateTime(nowDate);
        obj.setUpdateTime(nowDate);
        itemTypeDao.save(obj);
    }

    @Override
    public void deleteById(String uid) {
        itemTypeDao.deleteById(uid);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(ItemTypeInfo itemTypeInfo) {
        itemTypeDao.update(itemTypeInfo);
    }

    @Override
    public int getTotalCount(ItemTypeInfo itemTypeInfo) {
        return itemTypeDao.queryTotalCount(itemTypeInfo);
    }

    @Override
    public BasePagePO<ItemTypeInfo> getBasePagePO(int pageIndex, int pageSize, ItemTypeInfo itemTypeInfo) {

        return null;
    }

    @Override
    public List<ItemTypeInfo> queryListPO(int pageIndex, int pageSize, ItemTypeInfo itemTypeInfo) {
        return null;
    }

    @Override
    public BasePagePO<ItemTypeInfo> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw) {
        ItemTypeInfo itemTypeInfo = new ItemTypeInfo();
        itemTypeInfo.setSearch(searchValue);
        BaseSearchPO<ItemTypeInfo> baseSearchPO = new BaseSearchPO<>();
        baseSearchPO.setObj(itemTypeInfo);
        baseSearchPO.setPageSize(pageSize);
        baseSearchPO.setPageIndex(pageIndex);
        baseSearchPO.setOrderName(orderColumn);
        baseSearchPO.setOrderValue(orderValue);
        /*
         *上面是构造查询条件
         * 下面是返回查询结构
         */
        List<ItemTypeInfo> itemTypeInfos = itemTypeDao.queryPage(baseSearchPO);
        int totalCount = this.getTotalCount(itemTypeInfo);
        BasePagePO<ItemTypeInfo> basePagePO = new BasePagePO<>();
        basePagePO.setData(itemTypeInfos);
        basePagePO.setDraw(draw);
        basePagePO.setRecordsTotal(totalCount);
        basePagePO.setRecordsFiltered(totalCount);
        return basePagePO;
    }
}
