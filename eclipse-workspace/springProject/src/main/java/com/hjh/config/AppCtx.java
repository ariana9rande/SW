package com.hjh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hjh.service.ChangePasswordService;
import com.hjh.service.MemberDao;
import com.hjh.service.MemberListPrinter;
import com.hjh.service.MemberPrinter;
import com.hjh.service.MemberRegisterService;

@Configuration
public class AppCtx
{
	@Bean
	public MemberDao memberDao()
	{
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc()
	{
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc()
	{
		ChangePasswordService pwdSvc =  new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter()
	{
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter()
	{
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
}
