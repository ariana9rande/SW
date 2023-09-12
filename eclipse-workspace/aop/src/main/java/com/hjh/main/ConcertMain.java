package com.hjh.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.hjh.concert.IUConcert;
import com.hjh.concert.Performance;
import com.hjh.concert.PianoConcert;
import com.hjh.config.ConcertConfig;

public class ConcertMain
{
	public static void main(String[] args) throws Exception
	{
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ConcertConfig.class);

		Performance performance = ctx.getBean("pianoConcert", PianoConcert.class);
		performance.perform();

		System.out.println("-------------------------------------------------------");
		
		performance = ctx.getBean("IUConcert", IUConcert.class);
	    performance.perform();
		ctx.close();
	}
}