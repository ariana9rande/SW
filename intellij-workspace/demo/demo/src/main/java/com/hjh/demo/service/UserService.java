package com.hjh.demo.service;

import com.hjh.demo.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private SqlSession sqlSession;
    private final String namespace = "com.hjh.mapper.UserMapper";

    @Autowired
    public UserService(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }

    public UserDTO auth(UserDTO userDTO)
    {
        System.out.println("userDTO = " + userDTO);
        return sqlSession.selectOne(namespace + ".auth", userDTO);
    }

}
