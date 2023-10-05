package com.hjh.demo.service;

import com.hjh.demo.model.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService
{

    private SqlSession sqlSession;
    private final String NAMESPACE = "com.hjh.mapper.BoardMapper";

    @Autowired
    public BoardService(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }

    public List<BoardDTO> selectAll()
    {
        return sqlSession.selectList(NAMESPACE + ".selectAll");
    }

    public BoardDTO selectOne(int article_no)
    {
        return sqlSession.selectOne(NAMESPACE + ".selectOne", article_no);
    }

    public void insert(BoardDTO boardDTO)
    {
        sqlSession.insert(NAMESPACE + ".insert", boardDTO);
    }

    public void update(BoardDTO boardDTO)
    {
        sqlSession.update(NAMESPACE + ".update", boardDTO);
    }

    public void delete(int id)
    {
        sqlSession.delete(NAMESPACE + ".delete", id);
    }
}