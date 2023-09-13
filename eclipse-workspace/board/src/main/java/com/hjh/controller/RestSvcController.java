package com.hjh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestSvcController
{
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello, world";
	}
}
