package com.sku.usercontainer.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private Date entryDate;
    private Date modifyDate;
}
