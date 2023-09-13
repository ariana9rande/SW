package com.hjh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjh.model.NoticeboardDto;
import com.hjh.service.BoardService;

@RestController
@RequestMapping("/api")
public class RestSvcController
{
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private NoticeboardDto noticeboardDto;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello, world";
	}
	
	@GetMapping("/article/{num}")
	public NoticeboardDto getArticle(@PathVariable("num") int articleNo)
	{
		noticeboardDto = boardService.viewArticle(articleNo);
		
		return noticeboardDto;
	}
	
	@GetMapping("/list")
	public List<NoticeboardDto> getArticleList(Model model)
	{
		List<NoticeboardDto> articleList = boardService.listArticles();
		
		return articleList;
	}
}
