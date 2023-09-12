package com.hjh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hjh.controller.HelloController;

@Configuration
public class ControllerConfig
{
	@Bean
	public HelloController hellController()
	{
		return new HelloController();
	}
}