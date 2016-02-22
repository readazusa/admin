package net.sunmingchun.www.admin.area.dao;

import net.sunmingchun.www.admin.area.po.AreaPO;

import java.util.List;

/**
 * Created by smc on 2016/1/11.
 */
public interface IAreaDao {
    public List<AreaPO> queryAreaByParentId(String id);
}
