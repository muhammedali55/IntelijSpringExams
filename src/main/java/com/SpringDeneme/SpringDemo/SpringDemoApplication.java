package com.SpringDeneme.SpringDemo;

import com.SpringDeneme.SpringDemo.dao.jpa.NaturalRepositoryImpl;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication
@EnableConfigurationProperties(value = MuhammetProperties.class)
@EnableJpaRepositories(repositoryBaseClass = NaturalRepositoryImpl.class)
public class SpringDemoApplication {

	public static void main(String[] args) {

	    SpringApplication app = new SpringApplication(SpringDemoApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}

}
