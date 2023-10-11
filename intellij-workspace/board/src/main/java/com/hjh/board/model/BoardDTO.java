package com.hjh.board.model;

import lombok.Data;

import java.sql.Date;

@Data
public class BoardDTO
{
    private int id;
    private int writerId;
    private String title;
    private String content;
    private Date entryDate;
    private Date modifyDate;
}
