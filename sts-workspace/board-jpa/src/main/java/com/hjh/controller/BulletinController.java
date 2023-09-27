package com.hjh.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hjh.model.entity.Bulletin;
import com.hjh.service.BulletinService;
import com.hjh.service.UserService;

@Controller
@RequestMapping("/sku")
public class BulletinController
{
	
	@Autowired
	private BulletinService bulletinService;
	
	@Autowired
	UserService userService;
	
	Logger logger = LoggerFactory.getLogger("com.hjh.controller.BulletinController");
	
	@RequestMapping({"/list", "/"})
	public String getArticleList(Model model)
	{
		List<Bulletin> articleList = bulletinService.listArticle();
		model.addAttribute("dataList", articleList);
		return "list";
	}
	
	@GetMapping("/add")
	@PreAuthorize("isAuthenticated()")
	public String writeArticle()
	{
		return "write";
	}
	
	@PostMapping("/addarticle")
	@PreAuthorize("isAuthenticated()")
	public String addArticle(@RequestParam(value="i_title") String title,
			@RequestParam(value="i_content") String content, Principal principal)
	{
		logger.debug("addArticle TITLE : ");
		
		Bulletin bulletin = new Bulletin();
		
		bulletin.setTitle(title);
		bulletin.setContent(content);
		bulletin.setWriter(userService.getUser(principal.getName()));
		bulletinService.addArticle(bulletin);
		
		return "redirect:list";
	}
	
	@GetMapping("/view")
	public ModelAndView viewArticle(@RequestParam(value="no") String articleNo)
	{
		logger.debug("articleNo: "+ articleNo);
		
		Bulletin bulletin = new Bulletin();
		
		bulletin = bulletinService.viewArticle(Integer.parseInt(articleNo));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("article", bulletin);
		return mv;
	}
	
	@PostMapping("/edit")
	@PreAuthorize("isAuthenticated()")
	public String editArticle(@RequestParam(value="articleNo") String articleNo,
			@RequestParam(value="title") String title,
			@RequestParam(value="content") String content, RedirectAttributes attr)
	{
		Bulletin bulletin = new Bulletin();
		
		bulletin.setId(Integer.parseInt(articleNo));
		bulletin.setTitle(title);
		bulletin.setContent(content);
		
		bulletinService.editArticle(bulletin);
		attr.addAttribute("no", articleNo);
		
		
		return "redirect:view";
	}
	
	@PostMapping("/remove")
	@PreAuthorize("isAuthenticated()")
	public String deleteArticle(@RequestParam(value="articleNo") String articleNo)
	{
		bulletinService.removeArticle(Integer.parseInt(articleNo));
		
		return "redirect:list";
	}
	
	@GetMapping("/info")
	@ResponseBody
	public Map<String, String> getInfo()
	{
		Map<String, String> map = new HashMap<>();
		map.put("name", "sku project");
		map.put("version", "1.0");
		map.put("author", "Tom");
		
		return map;
	}
	
	@GetMapping("/dogandcat")
	public String upload() throws Exception
	{
		return "classifier";
	}
}