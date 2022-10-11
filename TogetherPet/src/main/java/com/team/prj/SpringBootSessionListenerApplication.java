package com.team.prj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBootSessionListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSessionListenerApplication.class, args);
	}
}