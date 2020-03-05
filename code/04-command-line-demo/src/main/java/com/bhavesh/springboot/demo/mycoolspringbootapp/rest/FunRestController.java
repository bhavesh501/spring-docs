package com.bhavesh.springboot.demo.mycoolspringbootapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that will return "Hello World"
	@GetMapping("/")
	public String sayHellow() {
		return "Hello World! Time on the server is " + LocalDateTime.now();
	}
	
	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
	
	// expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day.";
	}
}
