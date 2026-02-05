package com.dep.backend_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Backend2Application {

	public static void main(String[] args) {

		ApplicationContext context =  SpringApplication.run(Backend2Application.class, args);

		Dev d = context.getBean(Dev.class);
		d.build();
	}

}
