package com.springboot.reactiveSpringBoot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class ReactiveSpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpringBoot2Application.class, args);
	}

	@Bean
	HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

}
