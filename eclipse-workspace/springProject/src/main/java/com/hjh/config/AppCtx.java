package com.hjh.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hjh.service.MemberPrinter;
import com.hjh.service.MemberSummaryPrinter;
import com.hjh.service.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"com.hjh.service"})
public class AppCtx
{
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1()
	{
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2()
	{
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public VersionPrinter versionPrinter()
	{
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
