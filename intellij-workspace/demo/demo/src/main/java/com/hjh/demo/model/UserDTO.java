package com.hjh.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO
{
    private int id;
    private String email;
    private String password;
    private String username;
    private String nickname;
    private Date entryDate;
    private Date modifyDate;
}
