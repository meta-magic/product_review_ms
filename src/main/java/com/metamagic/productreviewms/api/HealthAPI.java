package com.metamagic.productreviewms.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/check")
public class HealthAPI {
	
	@GetMapping(value = "/live")
	public ResponseEntity<String> checklive(){
		return new ResponseEntity<String>("App is Live", HttpStatus.OK);
	}
	
	@GetMapping(value = "/ready")
	public ResponseEntity<String> checkready(){
		return new ResponseEntity<String>("App is Ready", HttpStatus.OK);
	}

}
