package com.dailycodebuffer.spring.data.jpa.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaTutorialApplication {
	@autowire 
	StudentRepository a;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaTutorialApplication.class, args);
		
		a.save(new Student("a","b","fsd@gmail.com","a","b","12"));
	}

}
