package net.sunmingchun.www.file.dao.impl;

import net.sunmingchun.www.file.dao.IUploadFileDao;
import net.sunmingchun.www.file.po.UploadFilePO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 念梓  on 2016/8/9.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Repository
public class UploadFileDaoImpl extends SqlSessionDaoSupport implements IUploadFileDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    @Override
    public void save(UploadFilePO uploadFileInfo) {
        this.getSqlSession().insert("UploadFilePO.save",uploadFileInfo);

    }
}
