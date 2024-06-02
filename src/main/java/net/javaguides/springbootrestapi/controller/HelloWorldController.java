package net.javaguides.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/Hello-World")
	public String HelloWorld() {
		
		return "Hello World";
		
	}
	
}
