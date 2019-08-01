package org.dzq.springbootmybatis.email;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Controller
public class EmailController {
	@Autowired 
	EmailService emailService;
	
	
	@RequestMapping("/sendSimpleEmail")
	@ResponseBody
	public String sendSimpleEmail() {
		emailService.sendSimpleMail("603557506@qq.com", "你好", "我就是想测试一下行的波");
		return "success";
	}
	
	
	@RequestMapping("/sendAttachmentEmail")
	@ResponseBody
	public String sendAttachmentEmail() {
		File file=new File("C:\\Users\\xxx-d2q\\Desktop\\测试文件夹\\图片\\pri6.jpg");
		emailService.sendAttachmentMail("603557506@qq.com", "你好", "这是带附件的邮件",file);
		return "success";
	}
	
	
	@RequestMapping("/sendTemplateEmail")
	@ResponseBody
	public String sendTemplateEmail() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		emailService.sendTemplateMail("603557506@qq.com", "你好", "info.html");
		return "success";
	}
}
