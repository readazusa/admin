package net.sunmingchun.www.shopcart.service.impl;

import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.shopcart.dao.IShopCartDao;
import net.sunmingchun.www.shopcart.po.ShopCartInfo;
import net.sunmingchun.www.shopcart.service.IShopCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2016/8/25.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Service
public class ShopCartServiceImpl implements IShopCartService {

    @Resource
    private IShopCartDao shopCartDao;

    @Override
    public ShopCartInfo queryObjectById(String id) {
        return null;
    }

    @Override
    public ShopCartInfo queryObjectById(int id) {
        return null;
    }

    @Override
    public List<ShopCartInfo> queryList() {
        return null;
    }

    @Override
    public void save(ShopCartInfo obj) {

    }

    @Override
    public void deleteById(String uid) {

    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(ShopCartInfo shopCartInfo) {

    }

    @Override
    public int getTotalCount(ShopCartInfo shopCartInfo) {
        return 0;
    }

    @Override
    public BasePagePO<ShopCartInfo> getBasePagePO(int pageIndex, int pageSize, ShopCartInfo shopCartInfo) {
        return null;
    }

    @Override
    public List<ShopCartInfo> queryListPO(int pageIndex, int pageSize, ShopCartInfo shopCartInfo) {
        return null;
    }
}
