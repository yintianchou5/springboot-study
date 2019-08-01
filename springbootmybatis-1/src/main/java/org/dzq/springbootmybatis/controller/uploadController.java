package org.dzq.springbootmybatis.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class uploadController {
	
	@RequestMapping("/uploadPage")
	public String uploadPage() {
		return "upload";
	}
	
	@RequestMapping("/uploadsPage")
	public String uploadsPage() {
		return "uploads";
	}
	
	/**
	 * 单个上传
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public String uploadFile(MultipartFile file,HttpServletRequest request) {
		try {
			//创建文件在服务端的存放路径
			String dir = request.getServletContext().getRealPath("/upload");
			File fileDir=new File(dir);
			if(!fileDir.exists()) {
				fileDir.mkdirs();
			}
			//生成文件在服务端存放的名字
			String fileSuffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String fileName=UUID.randomUUID().toString()+fileSuffix;
			
			File files=new File(fileDir+"/"+fileName);
			//上传
			file.transferTo(files);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return "上传失败";
		} catch (IOException e) {
			e.printStackTrace();
			return "上传失败";
		}
		return "上传成功";
	}
	
	
	
	@RequestMapping(value="/upload/batch",method=RequestMethod.POST)
	@ResponseBody
	public String uploadFiles(MultipartFile[] file,HttpServletRequest request) {
		try {
			//创建文件在服务端的存放路径
			String dir = request.getServletContext().getRealPath("/upload");
			File fileDir=new File(dir);
			if(!fileDir.exists()) {
				fileDir.mkdirs();
			}
			for(int i=0;i<file.length;i++) {
				
			
			//生成文件在服务端存放的名字
			String fileSuffix=file[i].getOriginalFilename().substring(file[i].getOriginalFilename().lastIndexOf("."));
			String fileName=UUID.randomUUID().toString()+fileSuffix;
			
			File files=new File(fileDir+"/"+fileName);
			//上传
			file[i].transferTo(files);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return "上传失败";
		} catch (IOException e) {
			e.printStackTrace();
			return "上传失败";
		}
		return "上传成功";
	}
}
