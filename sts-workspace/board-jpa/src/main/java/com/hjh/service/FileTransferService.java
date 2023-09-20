package com.hjh.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileTransferService
{
	public String webToLocal(MultipartFile uploadfile) throws IOException
	{
		String check;
		double doubleCheck;
		String baseUrl = "C:\\Users\\admin\\hjh\\vs-workspace\\python\\Django\\cats-vs-dogs\\input_images\\";
		
		if(!uploadfile.isEmpty())
		{
			File newFileName = new File(baseUrl + uploadfile.getOriginalFilename());
			
			uploadfile.transferTo(newFileName);
			
			check = RequestUtil.restRequest("http://localhost:8000/catdog/predict/", baseUrl +
					uploadfile.getOriginalFilename());
			
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
