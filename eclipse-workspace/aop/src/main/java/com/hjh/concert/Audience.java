package com.hjh.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience
{
	@Pointcut("execution(* com.hjh.concert.Performance.perform(..))")
	public void performance()
	{
		
	}
	
//	@Before("performance()")
//	public void silenceCellPhone()
//	{
//		System.out.println("Silencing cell phones");
//	}
//	
//	@Before("performance()")
//	public void takeSeats()
//	{
//		System.out.println("Taking seats");
//	}
//	
//	@AfterReturning("performance()")
//	public void applause()
//	{
//		System.out.println("CLAP");
//	}
//	
//	@AfterReturning("performance()")
//	public void demandRefund()
//	{
//		System.out.println("Demanding a refund");
//	}
	
	@Around("performance()")
	public void WatchPerformace(ProceedingJoinPoint jp)
	{
		try
		{
			System.out.println("Silencing cell phones");
			System.out.println("Taking seats");
			jp.proceed();
			System.out.println("CLAP");
		}
		catch(Throwable e)
		{
			System.out.println("Demanding a refund");
		}
	}
}
