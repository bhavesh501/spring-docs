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
}
