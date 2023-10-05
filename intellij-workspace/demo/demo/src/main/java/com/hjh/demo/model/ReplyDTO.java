package com.hjh.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ReplyDTO
{
    private int id;
    private String content;
    private int writerId;
    private int boardId;
    private LocalDateTime entryDate;
    private LocalDateTime modifyDate;
}
