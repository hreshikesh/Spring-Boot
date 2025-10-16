package com.example.GoldShop;

import com.example.GoldShop.restcontroller.GoldRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoldShopApplication {

	private static final Logger log = LoggerFactory.getLogger(GoldShopApplication.class);

	public GoldShopApplication(){
		log.info("Running goldShopApplication const" );
	}

	public static void main(String[] args) {
		SpringApplication.run(GoldShopApplication.class, args);
	}

}
