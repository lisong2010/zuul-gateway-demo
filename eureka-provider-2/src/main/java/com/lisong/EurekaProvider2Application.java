package com.lisong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProvider2Application.class, args);
	}

	@Bean
	public MyHealthIndicator getMyHealthIndicator() {
		return new MyHealthIndicator();
	}

	@Bean
	public MyEndpoint myEndpoint(){
		return new MyEndpoint();
	}
}

@RestController
class ProviderController{

	@Autowired
	MyHealthIndicator myHealthIndicator;

	@RequestMapping("/")
	public String root() throws InterruptedException {
		Thread.sleep(200);
		return "Hello, this is provider 2";
	}

	@RequestMapping("/status/{status}")
	public String status(@PathVariable("status") String status) throws InterruptedException {
		myHealthIndicator.setStatus(status);
		return "Hello, this is provider 2";
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello world, this is provider 2";
	}
}


