package com.example.consumer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController("/api")
public class GreetController {
	
	@GetMapping("/greet")
	public ResponseEntity<String> greetUser(){
		
		return new ResponseEntity<String>("Hello there!", HttpStatus.OK);
	}

}
