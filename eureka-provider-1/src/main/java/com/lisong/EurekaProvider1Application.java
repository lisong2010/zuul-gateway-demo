package com.lisong;

import com.netflix.discovery.EurekaClient;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProvider1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProvider1Application.class, args);
	}
}


@RestController
class ProviderController{

	@Autowired
	EurekaClient discoveryClient;

	@RequestMapping("/")
	public String root() throws InterruptedException {
		Thread.sleep(200);
		return "Hello, this is provider 1, app size is " + discoveryClient.getApplications().size();
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello world, this is provider 1";
	}
}

