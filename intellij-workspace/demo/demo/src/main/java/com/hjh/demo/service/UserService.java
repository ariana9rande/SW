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
        System.out.println("UserService.auth");
        System.out.println("userDTO.id = " + userDTO.getId());
        System.out.println("userDTO.name = " + userDTO.getUsername());
        System.out.println("userDTO.email = " + userDTO.getEmail());
        System.out.println("userDTO.password = " + userDTO.getPassword());
        return sqlSession.selectOne(namespace + ".auth", userDTO);
    }

}
