package com.service.developersjourneysource.email;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import static java.util.Locale.ENGLISH;

import lombok.RequiredArgsConstructor;

@Service
public class EmailService {

	@Autowired
	private EmailSender emailSender;
	
	public void sendOnBoardMail() {
	
		var context = new Context(ENGLISH);
		context.setVariable("name", "test");
		context.setVariable("subscriptionDate", new Date());
		context.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));
		//context.setVariable("imageResourceName", imageResourceName);
		emailSender.sendEmail(Arrays.asList("sachin19927@gmail.com"), "html/mail-template-boot.html", context);
		emailSender.sendEmail(Arrays.asList("sachin19927@gmail.com"), "text/sample.txt", context);
	}
	
	
}
