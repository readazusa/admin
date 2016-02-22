package net.sunmingchun.www.admin.area.service.impl;

import net.sunmingchun.www.admin.area.dao.IAreaDao;
import net.sunmingchun.www.admin.area.po.AreaPO;
import net.sunmingchun.www.admin.area.service.IAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by smc on 2016/1/11.
 */
@Service
public class AreaServiceImpl implements IAreaService {

    @Resource
    private IAreaDao areaDao;

    @Override
    public List<AreaPO> getAreaByParentId(String id) {

        return areaDao.queryAreaByParentId(id);
    }
}
