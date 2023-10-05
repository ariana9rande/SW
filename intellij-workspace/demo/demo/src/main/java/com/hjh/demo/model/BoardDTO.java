package com.hjh.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDTO
{
    private int id;
    private String content;
    private String title;
    private Date entryDate;
    private Date modifyDate;
    private int writerId;
}
