package com.hjh.user.service;

import com.hjh.user.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final SqlSession SESSION;

    private final String NAMESPACE = "com.hjh.mapper.UserMapper";

    @Autowired
    private UserService(SqlSession session)
    {
        this.SESSION = session;
    }

    public UserDTO auth(UserDTO attempt)
    {
        return SESSION.selectOne("auth", attempt);
    }
}
