package com.appletreesg.carparkapi.dao;

import com.appletreesg.carparkapi.object.domain.CarparkInfo;
import com.appletreesg.carparkapi.mapper.CarparkMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: zhihua.su
 * @date: 2019-07-30
 * @time: 16:27
 */

@Repository
public class CarparkDaoImpl implements CarparkDao {
    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public CarparkDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public int insertCarpark(CarparkInfo carparkInfo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CarparkMapper carparkMapper = sqlSession.getMapper(CarparkMapper.class);
        int affected = carparkMapper.insert(carparkInfo);
        return affected;
    }
}
