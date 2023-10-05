package com.hjh.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class BoardDTO
{
    private int id;
    private String content;
    private String title;
    private LocalDateTime entryDate;
    private LocalDateTime modifyDate;
    private int writerId;
    private String nickname;
}
