package com.hjh.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class UserDTO
{
    private int id;
    private String email;
    private String password;
    private String username;
    private String nickname;
    private LocalDateTime entryDate;
    private LocalDateTime modifyDate;
}
