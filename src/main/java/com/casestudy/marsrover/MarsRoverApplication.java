package com.casestudy.marsrover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarsRoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsRoverApplication.class, args);
		EntryToPlateau entryToPlateau = new EntryToPlateau();
		entryToPlateau.begin();
	}
}
