package org.dzq.springbootmybatis.email;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private EmailConfig emailConfig;
	//在mail依赖中
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfig;
	@Override
	public void sendSimpleMail(String sendTo, String title, String content) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom(emailConfig.getEmailFrom());
		message.setTo(sendTo);
		message.setSubject(title);
		message.setText(content);
		javaMailSender.send(message);
	}
	@Override
	public void sendAttachmentMail(String sendTo, String title, String content, File file) {
		MimeMessage message=javaMailSender.createMimeMessage();
		boolean multipart=true;
		try {
			MimeMessageHelper messageHelper=new MimeMessageHelper(message,multipart);
			messageHelper.setFrom(emailConfig.getEmailFrom());
			messageHelper.setTo(sendTo);
			messageHelper.setSubject(title);
			messageHelper.setText(content);
			FileSystemResource dataSource=new FileSystemResource(file);
			messageHelper.addAttachment("这里填附件名", dataSource);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(message);
	}
	@Override
	public void sendTemplateMail(String sendTo, String title, String content) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		MimeMessage message=javaMailSender.createMimeMessage();
		boolean multipart=true;
		try {
			MimeMessageHelper messageHelper=new MimeMessageHelper(message,multipart);
			messageHelper.setFrom(emailConfig.getEmailFrom());
			messageHelper.setTo(sendTo);
			messageHelper.setSubject(title);
			Map<String,String> map=new HashMap<>();
			map.put("username", "小李");
			
			Template template = freeMarkerConfig.getConfiguration().getTemplate(content);
			String info = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
			messageHelper.setText(info,true);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(message);
	}

}
