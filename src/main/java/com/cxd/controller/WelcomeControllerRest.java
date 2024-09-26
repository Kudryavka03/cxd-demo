package com.cxd.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeControllerRest {
	@GetMapping("/welcome2")  
	public int hello2() {
		return 1001;
	}
}
