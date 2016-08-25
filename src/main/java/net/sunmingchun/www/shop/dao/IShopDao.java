package net.sunmingchun.www.shop.dao;

import net.sunmingchun.www.base.dao.IDao;
import net.sunmingchun.www.shop.po.ShopInfo;

import java.util.List;

/**
 * Created by 念梓  on 2016/8/15.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
public interface IShopDao extends IDao<ShopInfo> {


    /**
     * 根据主 从店铺的标志查询
     * @param index
     * @return
     */
    public List<ShopInfo> queryListByIndex(String index);




}
