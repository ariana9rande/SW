package com.hjh.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileTransferService
{
	public String webToLocal(MultipartFile uploadFile) throws IOException
	{
		String check;
		double doubleCheck;
		String baseUrl = "C://Users/admin/hjh/vs-workspace/python/Django/cats-vs-dogs/input_images";
		
		if(!uploadFile.isEmpty())
		{
			File newFileName = new File(baseUrl + uploadFile.getOriginalFilename());
			
			uploadFile.transferTo(newFileName);
			
			check = RequestUtil.restRequest("http://localhost:8000/catdog/predict/", baseUrl +
					uploadFile.getOriginalFilename());
			
			System.out.println("result from Django : " + check);
			doubleCheck = Double.parseDouble(check);
			
			if(doubleCheck < 0.5)
			{
				return "cat";
			}
			else
			{
				return "dog";
			}
		}
		return "error";
	}
}
