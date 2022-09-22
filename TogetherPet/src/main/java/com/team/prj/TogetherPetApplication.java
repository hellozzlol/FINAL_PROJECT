package com.team.prj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.team.prj.**.mapper")
public class TogetherPetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TogetherPetApplication.class, args);
	}

}

