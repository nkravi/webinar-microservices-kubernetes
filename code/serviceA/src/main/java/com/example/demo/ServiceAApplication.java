package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@SpringBootApplication
@RestController
public class ServiceAApplication {
	
	@Value("${serviceb-hostname}")
	private String hostName;
	@Value("${serviceb-port}")
	private String portNumber;
	
	private String getIpAddress(){
		try {
			return   InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			return "Error in fetching IP";
		} 
	}
	
	@RequestMapping("/hai")
	public String sayHai(){
		return "Hai from Service A-  "+ getIpAddress();
	}

	@RequestMapping("/serviceB")
	public String callServiceB(){
		try {
			String url = "http://"+hostName+":"+portNumber+"/hai";
			System.out.println(url);
			HttpResponse<String> response= Unirest.get(url).asString();
			return response.getBody();
		} catch (UnirestException e) {
			return "Error occured!";
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}
}
