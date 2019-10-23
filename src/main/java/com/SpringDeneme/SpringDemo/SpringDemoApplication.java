package com.SpringDeneme.SpringDemo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = MuhammetProperties.class)
public class SpringDemoApplication {

	public static void main(String[] args) {

	    SpringApplication app = new SpringApplication(SpringDemoApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}

}
