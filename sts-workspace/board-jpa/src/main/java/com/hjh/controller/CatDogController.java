package com.hjh.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hjh.service.FileTransferService;

@RestController
@RequestMapping("/rest")
public class CatDogController
{
	@Autowired
	FileTransferService fileTransferService;

	Map<String, String> map = new HashMap<>();

	@PostMapping("/uploadfile")
	public Map<String, String> uploadImage(@RequestPart(value = "uploadfile") MultipartFile uploadFile)
			throws IllegalStateException, IOException
	{
		String catordog = fileTransferService.webToLocal(uploadFile);
		map.put("catordog", catordog);
		System.out.println(map);
		
		return map;
	}
}
