package com.hjh.demo.service;

import com.hjh.demo.model.BoardDTO;
import com.hjh.demo.model.ReplyDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService
{
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.hjh.mapper.ReplyMapper";

    @Autowired
    public ReplyService(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }

    public void insert(ReplyDTO replyDTO)
    {
        sqlSession.insert(NAMESPACE + ".insert", replyDTO);
    }

    public List<ReplyDTO> selectAll()
    {
        return sqlSession.selectList(NAMESPACE + ".selectAll");
    }
}