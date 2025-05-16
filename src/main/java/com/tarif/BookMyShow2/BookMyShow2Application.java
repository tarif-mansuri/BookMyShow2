package com.tarif.BookMyShow2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BookMyShow2Application {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShow2Application.class, args);
	}

}
