package com.hjh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hjh.controller.BoardController;
import com.hjh.model.BoardDao;
import com.hjh.model.NoticeboardDto;
import com.hjh.service.BoardService;

@Configuration
public class BoardConfig
{
	@Bean
	public NoticeboardDto noticeboardDto()
	{
		return new NoticeboardDto();
	}
	
	@Bean
	public BoardDao boardDao()
	{
		return new BoardDao();
	}
	
	@Bean
	public BoardService boardService()
	{
		return new BoardService();
	}
	
	@Bean
	public BoardController boardController()
	{
		return new BoardController();
	}
}
