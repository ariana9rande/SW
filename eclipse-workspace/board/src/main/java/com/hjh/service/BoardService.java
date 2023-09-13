package com.hjh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hjh.model.BoardDao;
import com.hjh.model.NoticeboardDto;

public class BoardService
{
	@Autowired
	private BoardDao boardDao;

	public List<NoticeboardDto> listArticles()
	{
		List<NoticeboardDto> articleList = boardDao.selectAllArticles();
		return articleList;
	}
	
	public void addArticle(NoticeboardDto article)
	{
		boardDao.insertArticle(article);
	}
}
