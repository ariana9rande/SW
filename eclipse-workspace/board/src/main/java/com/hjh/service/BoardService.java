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
	
	public NoticeboardDto viewArticle(int articleNo)
	{
		NoticeboardDto article = boardDao.selectArticle(articleNo);
		return article;
	}
	
	public void editArticle(NoticeboardDto article)
	{
		boardDao.updateArticle(article);
	}
	
	public void removeArticle(int articleNo)
	{
		boardDao.deleteArticle(articleNo);
	}
}
