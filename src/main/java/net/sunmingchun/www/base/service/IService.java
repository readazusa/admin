package net.sunmingchun.www.base.service;

import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.po.BaseSearchPO;

import java.util.List;

/**
 * Created by smc on 2015/11/19.
 * 基础service
 */
public interface IService<T> {
    public T queryObjectById(String id);

    public T queryObjectById(int id);

    public List<T> queryList();

    public void save(T obj);   //保存信息

    public void deleteById(String uid);

    public void deleteById(int uid);

    public void update(T t);

    public int getTotalCount(T t);

    public BasePagePO<T> getBasePagePO(int pageIndex, int pageSize, T t);

    public List<T> queryListPO(int pageIndex, int pageSize, T t);


}
