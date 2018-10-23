package com.lisong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProvider2Application.class, args);
	}
}

@RestController
class ProviderController{

	@RequestMapping("/")
	public String root() throws InterruptedException {
		Thread.sleep(200);
		return "Hello, this is provider 2";
	}
}


