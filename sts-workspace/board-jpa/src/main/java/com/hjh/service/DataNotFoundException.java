package com.hjh.service;

public class DataNotFoundException extends RuntimeException
{
	public DataNotFoundException()
	{
	}

	public DataNotFoundException(String message)
	{
		super(message);
	}
}