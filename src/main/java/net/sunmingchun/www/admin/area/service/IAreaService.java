package net.sunmingchun.www.admin.area.service;

import net.sunmingchun.www.admin.area.po.AreaPO;

import java.util.List;

/**
 * Created by smc on 2015/12/6.
 */
public interface IAreaService {

    public List<AreaPO> getAreaByParentId(String id);
}
