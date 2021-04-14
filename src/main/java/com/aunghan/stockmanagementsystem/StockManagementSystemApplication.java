package com.aunghan.stockmanagementsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class StockManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(StockManagementSystemApplication.class, args);
		log.info("--Stock Management System--");
	}
}
