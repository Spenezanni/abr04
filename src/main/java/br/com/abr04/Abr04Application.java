package br.com.abr04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@EnableSpringDataWebSupport
@SpringBootApplication
public class Abr04Application {

	public static void main(String[] args) {
		SpringApplication.run(Abr04Application.class, args);
	}

}
