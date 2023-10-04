package com.hjh.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class BulletinDTO
{
    private int articleNo;
    private String content;
    private String title;
    private Date writeDate;
    private int writerId;
}
