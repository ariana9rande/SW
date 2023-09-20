package com.hjh.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileTransferService
{
//	public String webToLocal(MultipartFile uploadfile) throws IOException
//	{
//		String check;
//		double doubleCheck;
//		String baseUrl = "C:\\Users\\admin\\hjh\\vs-workspace\\python\\Django\\cats-vs-dogs\\input_images";
//		
//		if(!uploadfile.isEmpty())
//		{
//			File newFileName = new File(baseUrl + uploadfile.getOriginalFilename());
//			
//			uploadfile.transferTo(newFileName);
//			
//			check = RequestUtil.restRequest("http://localhost:8000/catdog/predict/", baseUrl +
//					uploadfile.getOriginalFilename());
//			
//			System.out.println("result from Django : " + check);
//			doubleCheck = Double.parseDouble(check);
//			
//			if(doubleCheck < 0.5)
//			{
//				return "cat";
//			}
//			else
//			{
//				return "dog";
//			}
//		}
//		return "error";
//	}
	
    private String uploadDir = "C:\\Users\\admin\\hjh\\vs-workspace\\python\\Django\\cats-vs-dogs\\input_images";

    public String webToLocal(MultipartFile uploadfile) throws IOException {
        if (uploadfile.isEmpty()) {
            return "error"; // 업로드된 파일이 없을 경우 에러 반환
        }

        // 업로드 디렉토리가 존재하지 않으면 생성
        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        // 업로드 파일의 이름을 유지하기 위해 고유한 파일명 생성
        String fileName = StringUtils.cleanPath(uploadfile.getOriginalFilename());
        String uniqueFileName = System.currentTimeMillis() + "_" + fileName;

        // 로컬 디렉토리에 파일 저장
        Path filePath = Paths.get(uploadPath.getAbsolutePath() + File.separator + uniqueFileName);
        uploadfile.transferTo(filePath);

        // Django 서버에 파일 경로를 보내 결과를 받아옴
        String check = RequestUtil.restRequest("http://localhost:8000/catdog/predict/", filePath.toString());

        // Django 서버에서 받은 결과를 가지고 분류
        System.out.println("Result from Django: " + check);
        double doubleCheck = Double.parseDouble(check);

        if (doubleCheck < 0.5) {
            return "cat";
        } else {
            return "dog";
        }
    }
}
