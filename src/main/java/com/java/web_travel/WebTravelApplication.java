package com.java.web_travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.awt.*;
import java.net.URI;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class WebTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebTravelApplication.class, args);
	}
}
