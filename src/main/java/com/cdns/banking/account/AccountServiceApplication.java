package com.cdns.banking.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/*
 * @SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration
 * Marks class as a Configuration class for Java-based configuration
 * Enables component-scanning so that the web controller classes are automatically discovered
 * Enables auto config feature of spring boot
 * 
 */
@SpringBootApplication
//Make my application act as a Eureka client
@EnableEurekaClient
//Application class to configure and bootstrap
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	//Perform synchronous HTTP requests - RestTemplate
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
