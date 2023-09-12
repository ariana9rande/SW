package com.hjh.concert;

import org.springframework.stereotype.Component;

@Component("IUConcert")
public class IUConcert implements Performance
{
	@Override
	public void perform() throws Exception
	{
		throw new Exception();
	}

}