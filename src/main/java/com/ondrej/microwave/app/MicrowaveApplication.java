package com.ondrej.microwave.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.ondrej.microwave")
@EnableJpaRepositories("com.ondrej.microwave.dao")
@EntityScan("com.ondrej.microwave.entity")
@EnableScheduling
@EnableAspectJAutoProxy
public class MicrowaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrowaveApplication.class, args);
	}

}
