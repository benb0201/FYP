package com.example.travelpal;

import com.example.travelpal.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class TravelpalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelpalApplication.class, args);
	}

}
