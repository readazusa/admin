package net.sunmingchun.www.shop.service.impl;

import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.shop.dao.IShopDao;
import net.sunmingchun.www.shop.po.ShopInfo;
import net.sunmingchun.www.shop.service.IShopService;
import net.sunmingchun.www.util.UuidUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 念梓  on 2016/8/11.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Service
public class ShopServiceImpl implements IShopService {

    @Resource
    private IShopDao shopDao;

    @Override
    public BasePagePO<ShopInfo> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw) {
        BasePagePO<ShopInfo> basePagePO = new BasePagePO<>();
        List<ShopInfo> shopInfos = new ArrayList<>();
        basePagePO.setData(shopInfos);
        basePagePO.setDraw(draw);
        basePagePO.setRecordsTotal(1);
        basePagePO.setRecordsFiltered(1);
        return basePagePO;
    }

    @Override
    public ShopInfo queryObjectById(String id) {
        return shopDao.queryObjectById(id);
    }

    @Override
    public ShopInfo queryObjectById(int id) {
        return null;
    }

    @Override
    public List<ShopInfo> queryList() {
        return null;
    }

    @Override
    public void save(ShopInfo obj) {
        obj.setId(UuidUtils.getUpperUuid());
        obj.setCreateTime(new Date());
        obj.setUpdateTime(new Date());
        if("0".equals(obj.getIndexType())){
            obj.setParentId(obj.getId());
        }
        shopDao.save(obj);
    }

    @Override
    public void deleteById(String uid) {
        shopDao.deleteById(uid);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(ShopInfo shopInfo) {
        shopInfo.setUpdateTime(new Date());
        shopDao.update(shopInfo);
    }

    @Override
    public int getTotalCount(ShopInfo shopInfo) {
        return 0;
    }

    @Override
    public BasePagePO<ShopInfo> getBasePagePO(int pageIndex, int pageSize, ShopInfo shopInfo) {
        BasePagePO<ShopInfo> basePagePO = new BasePagePO<>();
        int totalCount = shopDao.queryTotalCount(shopInfo);
        BaseSearchPO<ShopInfo> baseSearchPO = new BaseSearchPO<>();
        baseSearchPO.setPageSize(pageSize);
        baseSearchPO.setPageIndex((pageIndex-1)*pageSize);
        List<ShopInfo> shopInfoList = shopDao.queryPage(baseSearchPO);
        basePagePO.setCurrentPage(pageIndex);
        basePagePO.setData(shopInfoList);
        basePagePO.setRecordsTotal(totalCount);
        return basePagePO;
    }

    @Override
    public List<ShopInfo> queryListPO(int pageIndex, int pageSize, ShopInfo shopInfo) {

        return null;
    }

    @Override
    public List<ShopInfo> getListByIndex(String index) {
        return shopDao.queryListByIndex(index);
    }
}
