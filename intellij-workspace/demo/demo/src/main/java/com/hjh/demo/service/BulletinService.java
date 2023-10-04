package com.hjh.demo.service;

import com.hjh.demo.model.BulletinDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulletinService
{

    private SqlSession sqlSession;
    private final String namespace = "com.hjh.mapper.BulletinMapper";

    @Autowired
    public BulletinService(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }

    public List<BulletinDTO> selectAll()
    {
        return sqlSession.selectList(namespace + ".selectAll");
    }

    public BulletinDTO selectOne(int article_no)
    {
        return sqlSession.selectOne(namespace + ".selectOne", article_no);
    }

    public void insert(BulletinDTO bulletinDTO)
    {
        sqlSession.insert(namespace + ".insert", bulletinDTO);
    }

    public void update(BulletinDTO bulletinDTO)
    {
        sqlSession.update(namespace + ".update", bulletinDTO);
    }

    public void delete(int article_no)
    {
        sqlSession.delete(namespace + ".delete", article_no);
    }
}