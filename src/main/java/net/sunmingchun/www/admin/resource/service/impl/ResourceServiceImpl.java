package net.sunmingchun.www.admin.resource.service.impl;

import net.sunmingchun.www.admin.resource.dao.IResourceDao;
import net.sunmingchun.www.admin.resource.po.ResourcePO;
import net.sunmingchun.www.admin.resource.service.IResourceService;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.util.UuidUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by smc on 2016/1/19.
 */
@Service
public class ResourceServiceImpl implements IResourceService {

    @Resource
    private IResourceDao resourceDao;

    @Override
    public BasePagePO<ResourcePO> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw) {
        ResourcePO resourcePO = new ResourcePO();
        resourcePO.setSearch(searchValue);
        BaseSearchPO<ResourcePO> baseSearchPO = new BaseSearchPO<>();
        baseSearchPO.setObj(resourcePO);
        baseSearchPO.setPageSize(pageSize);
        baseSearchPO.setPageIndex(pageIndex);
        baseSearchPO.setOrderName(orderColumn);
        baseSearchPO.setOrderValue(orderValue);
        /*
         *上面是构造查询条件
         *
         * 下面是返回查询结构
         */
        List<ResourcePO> resourcePOList = resourceDao.queryPage(baseSearchPO);
        int totalCount = this.getTotalCount(resourcePO);
        BasePagePO<ResourcePO> basePagePO = new BasePagePO<>();
        basePagePO.setData(resourcePOList);
        basePagePO.setDraw(draw);
        basePagePO.setRecordsTotal(totalCount);
        basePagePO.setRecordsFiltered(totalCount);
        return basePagePO;
    }

    @Override
    public ResourcePO queryObjectById(String id) {
        return resourceDao.queryObjectById(id);
    }

    @Override
    public ResourcePO queryObjectById(int id) {
        return resourceDao.queryObjectById(id);
    }

    @Override
    public void save(ResourcePO obj) {
        if(StringUtils.isBlank(obj.getId())){
            obj.setId(UuidUtils.getUpperUuid());
            obj.setCreateTime(new Date());
            obj.setUpdateTime(new Date());
        }
        this.resourceDao.save(obj);
    }

    @Override
    public void deleteById(String uid) {
        this.resourceDao.deleteById(uid);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(ResourcePO resourcePO) {
        resourcePO.setUpdateTime(new Date());
        this.resourceDao.update(resourcePO);
    }

    @Override
    public int getTotalCount(ResourcePO resourcePO) {
        return this.resourceDao.queryTotalCount(resourcePO);
    }

    @Override
    public BasePagePO<ResourcePO> getBasePagePO(int pageIndex, int pageSize, ResourcePO resourcePO) {
        return null;
    }

    @Override
    public List<ResourcePO> queryListPO(int pageIndex, int pageSize, ResourcePO resourcePO) {
        return null;
    }

    @Override
    public List<ResourcePO> queryList() {
        return resourceDao.queryList();
    }
}
