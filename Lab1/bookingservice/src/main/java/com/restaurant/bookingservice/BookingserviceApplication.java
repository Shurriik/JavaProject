package com.restaurant.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class BookingserviceApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(BookingserviceApplication.class, args);
        System.out.println("Cервис запущен!");
        System.out.println("User API:  http://localhost:8080/api/user/tables");
        System.out.println("Admin API: http://localhost:8080/api/admin/tables");
	}

	@GetMapping("/")
    public String home() 
	{
        return "Cервер работает!";
	}
	
}
