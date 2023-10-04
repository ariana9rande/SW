package com.hjh.demo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
//@Alias("userDTO")
public class UserDTO
{
    private int id;
    private String email;
    private String password;
    private String username;
}
