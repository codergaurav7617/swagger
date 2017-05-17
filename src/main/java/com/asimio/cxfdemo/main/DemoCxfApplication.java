package com.asimio.cxfdemo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.asimio.cxfdemo.rest" })
public class DemoCxfApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCxfApplication.class, args);
	}
}