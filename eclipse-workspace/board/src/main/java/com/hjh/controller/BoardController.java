package com.hjh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hjh.model.NoticeboardDto;
import com.hjh.service.BoardService;

@Controller
@RequestMapping("/sku")
public class BoardController
{
	@Autowired
	private BoardService boardService;
	@Autowired
	private NoticeboardDto noticeboardDto;
	
	@RequestMapping({"/list", "/"})
	public String getArticleList(Model model)
	{
		List<NoticeboardDto> articleList = boardService.listArticles();
		model.addAttribute("dataList", articleList);
		return "list";
	}
	
	@GetMapping("/add")
	public String writeArticle()
	{
		return "write";
	}
	
	@PostMapping("/addarticle")
	public String addArticle(@RequestParam(value="i_title") String title, @RequestParam(value="i_content")String content)
	{
		noticeboardDto.setTitle(title);
		noticeboardDto.setContent(content);
		noticeboardDto.setWrite_id("admin");
		boardService.addArticle(noticeboardDto);
		return "redirect:list";
	}
}
