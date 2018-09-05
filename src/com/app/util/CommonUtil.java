package com.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class CommonUtil {

	@Autowired
	private JavaMailSender mail;
	
	public boolean sendmail(String toemail,String Subject,String text,final CommonsMultipartFile file){
		
		boolean flag=false;
		try {
			MimeMessage message=mail.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			helper.setTo(toemail);
			helper.setSubject(Subject);
			helper.setText(text);
			helper.setSentDate(new Date());
			helper.setFrom("raghavs025@gmail.com");
			
			if(file!=null){
				helper.addAttachment(file.getOriginalFilename(), 
						new InputStreamSource(){

					@Override
					public InputStream getInputStream() throws IOException {
						return file.getInputStream();
					}
				});
			}
			//send email
			mail.send(message);
			flag=true;
		}
		catch (MessagingException e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean sendmail(String toemail,String Subject,String text){
		return sendmail(toemail, Subject, text, null);
	}
}
