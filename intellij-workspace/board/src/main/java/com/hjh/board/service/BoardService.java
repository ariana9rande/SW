package com.hjh.board.service;

import com.hjh.board.model.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService
{
    @Autowired
    private SqlSession sqlSession;

    private final String NAMESPACE = "com.hjh.mapper.BoardMapper";

    public List<BoardDTO> selectAll()
    {
        return sqlSession.selectList(NAMESPACE + ".selectAll");
    }

    public BoardDTO selectOne(int id)
    {
        return sqlSession.selectOne(NAMESPACE + ".selectOne", id);
    }
}
