package net.sunmingchun.www.admin.user.dao.impl;


import net.sunmingchun.www.admin.user.dao.IUserDao;
import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.admin.user.po.UserRolePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by smc on 2015/11/19.
 */
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void save(UserPO obj) {
        this.getSqlSession().insert( "UserPO.save",obj);
    }

    @Override
    public void deleteById(String uid) {
        this.getSqlSession().delete("UserPO.delete",uid);
    }


    @Override
    public void deleteUserRoleByUserId(String userId) {
        this.getSqlSession().delete("UserPO.deleteUserRole",userId);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(UserPO t) {
        this.getSqlSession().update("UserPO.update",t);
    }

    @Override
    public UserPO queryObjectById(String id) {
        return this.getSqlSession().selectOne("UserPO.select",id);
    }

    @Override
    public UserPO queryObjectById(int id) {
        return null;
    }

    @Override
    public List<UserPO> queryPage(BaseSearchPO<UserPO> baseSearchPO) {
        return this.getSqlSession().selectList("UserPO.queryPage",baseSearchPO);
    }

    @Override
    public int queryTotalCount(UserPO userPO) {
        return this.getSqlSession().selectOne("UserPO.queryTotalCount",userPO);
    }

    @Override
    public void saveUserRole(UserRolePO userRolePO) {
        this.getSqlSession().insert("UserPO.saveUserRole",userRolePO);
    }

    @Override
    public List<UserPO> queryList() {
        return null;
    }

    @Override
    public List<String> selectRoleIdsByUserId(String userId) {
        return this.getSqlSession().selectList("UserPO.selectRoleIdsByUserId",userId);
    }

    @Override
    public UserPO validateUser(Map<String,String> map){
        return this.getSqlSession().selectOne("UserPO.validateUser",map);
    }
}
