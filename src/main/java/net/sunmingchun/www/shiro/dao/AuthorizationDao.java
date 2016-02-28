package net.sunmingchun.www.shiro.dao;

import net.sunmingchun.www.admin.resource.po.ResourcePO;
import net.sunmingchun.www.admin.role.po.RolePO;
import net.sunmingchun.www.admin.user.po.UserPO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * net.sunmingchun.www.shiro.dao
 * Created by smc
 * date on 2016/2/28.
 * Email:sunmch@163.com
 * 用户认证与授权dao
 */
@Repository
public class AuthorizationDao extends SqlSessionDaoSupport {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public UserPO getValidateUser(Map<String,String> map){
        return this.getSqlSession().selectOne("ShiroAuth.validateUser",map);
    }

    public List<RolePO> queryAuthRolesByUserId(String userId){
        return this.getSqlSession().selectList("ShiroAuth.queryAuthRolesByUserId",userId);
    }

    public List<ResourcePO> queryAuthResourcesByUserId(String userId){
        return  this.getSqlSession().selectList("ShiroAuth.queryAuthResourcesByUserId",userId);
    }


}
