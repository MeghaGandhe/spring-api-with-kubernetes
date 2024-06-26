package com.kubernetesapi.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@GetMapping("/data")
	public ResponseEntity<String> getData() {
		return new ResponseEntity<String>("Hi:Hello", HttpStatus.OK);
	}

}
