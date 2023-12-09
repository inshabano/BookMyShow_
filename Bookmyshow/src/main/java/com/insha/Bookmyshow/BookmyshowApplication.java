package com.insha.Bookmyshow;

import com.insha.Bookmyshow.DTOs.signUpRequestDto;
import com.insha.Bookmyshow.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BookmyshowApplication implements CommandLineRunner {
	@Autowired
	private UserController userController;

	@Override
	public void run(String... args) throws Exception {
		signUpRequestDto request = new signUpRequestDto();
		request.setEmail("insha@gmail.com");
		request.setPassword("rootpass");
		userController.signUp(request);
	}

	public static void main(String[] args) {

		SpringApplication.run(BookmyshowApplication.class, args);
	}

}
