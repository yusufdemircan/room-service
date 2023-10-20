package com.yedy.roomservice;

import com.yedy.roomservice.mikroservices.UserClient;
import com.yedy.roomservice.model.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@SpringBootApplication
@EnableFeignClients
public class RoomServiceApplication implements ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(RoomServiceApplication.class);
	@Autowired
	private UserClient userClient;

	public static void main(String[] args) {
		SpringApplication.run(RoomServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			UserDto resp = userClient.getUserTest("Bearer yedy");
			logger.info("Response body: [{}]", resp);
		} catch (Exception e) {
			logger.error("An exception occurred call order service: ", e);
		}
	}
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}
}
