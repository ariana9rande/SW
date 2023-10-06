package com.hjh.movie.service;

import com.hjh.movie.model.User;
import com.hjh.movie.model.UserRole;
import com.hjh.movie.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void register(String username, String password, String passwordConfirm, String nickname) throws Exception
    {
        if(userRepository.findByUsername(username) != null)
        {
            throw new Exception("이미 사용중인 ID입니다.");
        }

        if(!password.equals(passwordConfirm))
        {
            throw new Exception("비밀번호 확인이 일치하지 않습니다.");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setRole(UserRole.NORMAL.getValue());

        userRepository.save(user);
    }

    public User login(String username, String password)
    {
        User login = userRepository.findByUsername(username);

        if(login != null && login.getPassword().equals(password))
            return login;

        return null;
    }
}
