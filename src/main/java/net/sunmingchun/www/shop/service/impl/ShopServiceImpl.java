package net.sunmingchun.www.shop.service.impl;

import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.shop.po.ShopInfo;
import net.sunmingchun.www.shop.service.IShopService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return null;
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

    }

    @Override
    public void deleteById(String uid) {

    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(ShopInfo shopInfo) {

    }

    @Override
    public int getTotalCount(ShopInfo shopInfo) {
        return 0;
    }

    @Override
    public BasePagePO<ShopInfo> getBasePagePO(int pageIndex, int pageSize, ShopInfo shopInfo) {
        return null;
    }

    @Override
    public List<ShopInfo> queryListPO(int pageIndex, int pageSize, ShopInfo shopInfo) {
        return null;
    }
}
