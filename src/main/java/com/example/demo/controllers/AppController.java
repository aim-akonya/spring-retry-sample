package com.example.demo.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.RetryService;

@RestController
public class AppController {
	
	private final RetryService retryWithoutRecovery;
	
	@Autowired
	public AppController( RetryService retryWithoutRecovery) {
		this.retryWithoutRecovery = retryWithoutRecovery;
	}
	
	@GetMapping("/test1")
	public ResponseEntity<String> testRetry() throws SQLException {
		retryWithoutRecovery.retryService("test");
		return null;
	}
}
