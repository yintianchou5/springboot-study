package org.dzq.springbootmybatis.email;

import java.io.File;
import java.io.IOException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public interface EmailService {
	//发送简单邮件
	void sendSimpleMail(String sendTo,String title,String content);
	
	
	
	//发送带附件的邮件
	void sendAttachmentMail(String sendTo,String title,String content,File file);
	
	//发送摸板邮件
	void sendTemplateMail(String sendTo,String title,String content) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException;
}
