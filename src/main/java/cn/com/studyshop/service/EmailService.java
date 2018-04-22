package cn.com.studyshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {

	@Autowired
	private RestTemplate restTemplate;

	public String sendEmail() {

		String requestUri = "http://localhost:8050/email-service/send/email?accessToken='aa'";

		return restTemplate.getForEntity(requestUri, String.class).getBody();
	}
}
