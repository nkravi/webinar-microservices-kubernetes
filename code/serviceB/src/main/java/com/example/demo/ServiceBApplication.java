package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceBApplication {
	
	private String getIpAddress(){
		try {
			return   InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			return "Error in fetching IP";
		} 
	}

	@RequestMapping("/hai")
	public String sayHai(){
		
		return "Hai from Service B-  "+ getIpAddress();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
	}
}
