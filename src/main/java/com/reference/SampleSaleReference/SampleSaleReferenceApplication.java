package com.reference.SampleSaleReference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SampleSaleReferenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSaleReferenceApplication.class, args);
	}

}
