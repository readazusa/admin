package net.sunmingchun.www.base.dao;

import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.base.po.BaseSearchPO;

import java.util.List;

/**
 * Created by smc on 2015/11/19.
 * 基础dao
 */
public interface IDao<T> {

    public void save(T obj);   //保存信息

    public void deleteById(String uid);

    public void deleteById(int uid);

    public void update(T t);

    public T  queryObjectById(String id);

    public T queryObjectById(int id);

    public List<T> queryList();

    public int queryTotalCount(T t);    //获取匹配条件的个数

    public List<T> queryPage(BaseSearchPO<T> baseSearchPO);   //获取分页的数据数

}
